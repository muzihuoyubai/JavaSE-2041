package club.banyuan.mbm.server;

import club.banyuan.mbm.entity.User;
import club.banyuan.mbm.service.UserService;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 实现了用户的新增和查询
 */
public class SocketHandler3 extends Thread {

  private Socket clientSocket;
  private UserService userService = new UserService();

  public SocketHandler3(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  @Override
  public void run() {
    try {
      // 开启浏览器的流，获取浏览器发送的数据
      InputStream inputStream = clientSocket.getInputStream();
      System.out.println(clientSocket.getInetAddress().getHostAddress());

      // 为了有更好的处理方法，将字节流转换为字符流
      // InputStreamReader 字节流到字符流的转换
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      String line = bufferedReader.readLine();
      if (line == null) {
        // 建立tcp连接之后，通常不会读取到null，除非连接关闭
        System.err.println("解析失败");
        return;
      }

      // GET / HTTP1.1
      StringTokenizer tokenizer = new StringTokenizer(line);
      MbmRequest mbmRequest = new MbmRequest();
      mbmRequest.setMethod(tokenizer.nextToken());
      mbmRequest.setPath(tokenizer.nextToken());

      // 循环读取请求头的信息，按照一行一行的方式读取，读取到空行则退出循环
      while (line != null && line.length() != 0) {
        if (line.startsWith("Host:")) {
          mbmRequest.setHost(line.replace("Host: ", ""));
        }
        if (line.startsWith("Content-Length:")) {
          mbmRequest.setContentLength(Integer.parseInt(line.replace("Content-Length: ", "")));
        }
        System.out.println(line);
        line = bufferedReader.readLine();
      }

      System.out.println(mbmRequest);
      if (mbmRequest.getContentLength() > 0) {
        char[] chars = new char[mbmRequest.getContentLength()];
        bufferedReader.read(chars);

        mbmRequest.setPayload(URLDecoder.decode(new String(chars), "utf-8"));
        // 断言
        // assert read == mbmRequest.getContentLength();
      }

      String resourcePath = mbmRequest.getPath();

      if (resourcePath.startsWith("/server")) {
        // 服务接口，需要对应每个路径一个处理代码块
        process(mbmRequest);
      } else {
        // 资源文件的路径，需要读取对应的文件内容返回
        responseResource(resourcePath);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        clientSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  /**
   * 处理请求数据
   *
   * @param mbmRequest 请求数据的封装对象
   */
  private void process(MbmRequest mbmRequest) throws IOException {
    switch (mbmRequest.getPath()) {
      case "/server/user/login": {
        Map<String, String> formData = mbmRequest.getFormData();
        if (userService.login(formData.get("name"), formData.get("pwd")) == null) {
          // 登录失败， 跳转到login.html
          responseRedirect(mbmRequest, "/login.html");
        } else {
          // 登录成功，跳转到 bill_list.html
          responseRedirect(mbmRequest, "/bill_list.html");
        }
      }
      break;
      case "/server/user/list": {
        List<User> userList = userService.getUserList();
        responseJson(userList);
      }
      break;
      case "/server/user/modify": {
        // map返回的数据key 和user的属性名基本一致，因此可以将map序列化成json字符串，然后把这个字符串再反序列化成User
        Map<String, String> formData = mbmRequest.getFormData();
        String data = JSONObject.toJSONString(formData);
        User user = JSONObject.parseObject(data, User.class);
        userService.addUser(user);
        responseRedirect(mbmRequest, "/user_list.html");
      }
    }
  }

  private void responseJson(Object object) throws IOException {
    String data = JSONObject.toJSONString(object);
    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

    out.writeBytes("HTTP/1.1 200 OK");
    out.writeBytes("\r\n");
    out.writeBytes("Content-Length: " + data.getBytes().length);
    out.writeBytes("\r\n");
    out.writeBytes("Content-Type: application/json;charset=utf-8;");
    out.writeBytes("\r\n");
    out.writeBytes("\r\n");
    out.write(data.getBytes());
  }

  private void responseRedirect(MbmRequest request, String path)
      throws IOException {
    OutputStream outputStream = clientSocket.getOutputStream();
    outputStream.write("HTTP/1.1 302 Found".getBytes());
    outputStream.write("\r\n".getBytes());
    // 告知浏览器请求结束，需要再次向请求给定的路径发起请求
    outputStream.write(("Location: " + "http://" + request.getHost() + path).getBytes());
    outputStream.write("\r\n".getBytes());

    // out.writeBytes("HTTP/1.1 302 Found");
    // out.writeBytes("\r\n");
    // out.writeBytes("Location: " + "http://" + request.getHost() + path);
    // out.writeBytes("\r\n");
  }

  private void responseResource(String resourcePath) throws IOException {
    if (resourcePath.startsWith("/")) {
      resourcePath = resourcePath.substring(1);
    }

    if (resourcePath.length() == 0) {
      resourcePath = "pages/login.html";
    } else if (resourcePath.startsWith("css") || resourcePath.startsWith("images") || resourcePath
        .startsWith("js") || resourcePath.contains(".html")) {
      resourcePath = "pages/" + resourcePath;
    }

    InputStream resourceAsStream = HttpServer.class.getClassLoader()
        .getResourceAsStream(resourcePath);

    if (resourceAsStream == null) {
      resourceAsStream = HttpServer.class.getClassLoader()
          .getResourceAsStream("pages/404.html");
    }

    OutputStream outputStream = clientSocket.getOutputStream();
    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
    if (resourcePath.contains(".html")) {
      outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
    }

    String contentLength = "Content-Length: " + resourceAsStream.available();
    outputStream.write(contentLength.getBytes());

    outputStream.write("\r\n".getBytes());
    outputStream.write("\r\n".getBytes());
    outputStream.write(resourceAsStream.readAllBytes());
  }
}
