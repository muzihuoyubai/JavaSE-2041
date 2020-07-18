package club.banyuan.mbm.server;

import club.banyuan.mbm.entity.User;
import club.banyuan.mbm.exception.BadRequestException;
import club.banyuan.mbm.exception.FormPostException;
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

public class SocketHandler extends Thread {

  private Socket clientSocket;
  private UserService userService = new UserService();

  public SocketHandler(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  @Override
  public void run() {
    MbmRequest mbmRequest = new MbmRequest();

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

      mbmRequest.setMethod(tokenizer.nextToken());
      mbmRequest.setPath(URLDecoder.decode(tokenizer.nextToken(), "utf-8"));

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
        responseResource(mbmRequest);
      }
    } catch (FormPostException e) {
      try {
        responseRedirect(mbmRequest, "/form_post_fail.html?msg=" + e.getMessage());
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }

    } catch (BadRequestException e) {
      try {
        responseFailJson(e.getMessage());
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }
    } catch (Exception e) {
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
          throw new FormPostException("用户名或密码错误!");
          // responseRedirect(mbmRequest, "/login.html");
        } else {
          // 登录成功，跳转到 bill_list.html
          responseRedirect(mbmRequest, "/bill_list.html");
        }
      }
      break;
      case "/server/user/list": {
        List<User> userList;
        // 如果payload不为null，表示需要根据用户名进行检索
        String payload = mbmRequest.getPayload();
        if (payload == null) {
          userList = userService.getUserList();

        } else {
          // 将待检索的用户名转换为user对象
          User user = JSONObject.parseObject(payload, User.class);
          userList = userService.getUserList(user);
        }

        responseJson(userList);
      }
      break;
      case "/server/user/modify": {
        // map返回的数据key 和user的属性名基本一致，因此可以将map序列化成json字符串，然后把这个字符串再反序列化成User
        Map<String, String> formData = mbmRequest.getFormData();
        String data = JSONObject.toJSONString(formData);
        User user = JSONObject.parseObject(data, User.class);
        if (user.getId() == 0) {
          userService.addUser(user);
        } else {
          userService.updateUser(user);
        }
        responseRedirect(mbmRequest, "/user_list.html");
      }
      break;
      case "/server/user/get": {
        String payload = mbmRequest.getPayload();
        System.out.println("/server/user/get");
        System.out.println(payload);
        User userId = JSONObject.parseObject(payload, User.class);
        User user = userService.getUserById(userId.getId());
        responseJson(user);
      }
      break;
      case "/server/user/delete": {
        String payload = mbmRequest.getPayload();
        User userId = JSONObject.parseObject(payload, User.class);
        userService.deleteUserById(userId.getId());
        responseOk();
      }
      break;
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

  private void responseOk() throws IOException {
    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

    out.writeBytes("HTTP/1.1 200 OK");
    out.writeBytes("\r\n");
    out.writeBytes("\r\n");
  }

  private void responseFailJson(String data) throws IOException {
    // String data = JSONObject.toJSONString(object);
    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

    out.writeBytes("HTTP/1.1 400 Bad request");
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

  private void responseResource(MbmRequest mbmRequest) throws IOException {
    String resourcePath = mbmRequest.getPath();
    if (resourcePath.startsWith("/")) {
      resourcePath = resourcePath.substring(1);
    }

    if (resourcePath.length() == 0) {
      resourcePath = "pages/login.html";
    } else if (resourcePath.startsWith("css") || resourcePath.startsWith("images") || resourcePath
        .startsWith("js") || resourcePath.contains(".html")) {
      resourcePath = "pages/" + resourcePath;
    }

    // form_post_fail.html?msg=异常信息描述
    if (resourcePath.contains("form_post_fail.html")) {
      // 获取异常信息描述
      InputStream resourceAsStream = HttpServer.class.getClassLoader()
          .getResourceAsStream(resourcePath);

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
      StringBuilder builder = new StringBuilder();

      String line = bufferedReader.readLine();
      while (line != null) {
        if (line.contains("${msg}")) {
          line = line.replace("${msg}", mbmRequest.getFormData().get("msg"));
        }
        builder.append(line);
        builder.append(System.lineSeparator());
        line = bufferedReader.readLine();
      }
      byte[] data = builder.toString().getBytes();
      OutputStream outputStream = clientSocket.getOutputStream();
      outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
      if (resourcePath.contains(".html")) {
        outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
      }

      String contentLength = "Content-Length: " + data.length;
      outputStream.write(contentLength.getBytes());

      outputStream.write("\r\n".getBytes());
      outputStream.write("\r\n".getBytes());
      outputStream.write(data);
      bufferedReader.close();
      return;
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
    resourceAsStream.close();
  }
}
