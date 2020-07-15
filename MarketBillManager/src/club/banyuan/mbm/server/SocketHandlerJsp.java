package club.banyuan.mbm.server;

import club.banyuan.mbm.service.UserService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Map;
import java.util.StringTokenizer;

public class SocketHandlerJsp extends Thread {

  private Socket clientSocket;

  public SocketHandlerJsp(Socket clientSocket) {
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
      case "/server/user/login":
        UserService userService = new UserService();
        Map<String, String> formData = mbmRequest.getFormData();
        if (userService.login(formData.get("name"), formData.get("pwd")) == null) {
          // 登录失败， 跳转到login.html
          responseRedirect(mbmRequest, "/login.html?loginfail");
        } else {
          // 登录成功，跳转到 bill_list.html
          responseRedirect(mbmRequest, "/bill_list.html");
        }
        break;
    }
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

    String msg = "";
    if (resourcePath.length() == 0) {
      resourcePath = "pages/login.html";
    } else if (resourcePath.startsWith("css") || resourcePath.startsWith("images") || resourcePath
        .startsWith("js") || resourcePath.contains(".html")) {
      if (resourcePath.contains("?")) {
        StringTokenizer stringTokenizer = new StringTokenizer(resourcePath, "?");
        resourcePath = stringTokenizer.nextToken();
        msg = stringTokenizer.nextToken();
      }
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

    StringBuilder stringBuilder = new StringBuilder();
    if (msg.length() > 0) {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
      String line = bufferedReader.readLine();
      while (line != null) {
        stringBuilder.append(line);
        if (line.contains("<div class=\"buttons\">")) {
          stringBuilder.append("<span style=\"color: red\">用户名或密码错误</span>");
        }
        line = bufferedReader.readLine();
      }
      String target = stringBuilder.toString();

      String contentLength = "Content-Length: " + target.getBytes().length;
      outputStream.write(contentLength.getBytes());

      outputStream.write("\r\n".getBytes());
      outputStream.write("\r\n".getBytes());
      outputStream.write(target.getBytes());
    } else {
      String contentLength = "Content-Length: " + resourceAsStream.available();
      outputStream.write(contentLength.getBytes());

      outputStream.write("\r\n".getBytes());
      outputStream.write("\r\n".getBytes());
      outputStream.write(resourceAsStream.readAllBytes());
    }

    resourceAsStream.close();
  }
}
