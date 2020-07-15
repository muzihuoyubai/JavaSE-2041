package club.banyuan.mbm.server;

import club.banyuan.mbm.entity.User;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpServerBakOther extends Thread {

  private Socket socket;

  public HttpServerBakOther(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      InputStream inputStream = socket.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

      MbmRequest mbmRequest = MbmRequest.parse(bufferedReader);
      if (mbmRequest == null) {
        return;
      }

      String path = mbmRequest.getPath();
      if ("/".equals(path)) {
        responseHtml("/login.html", outputStream);
      } else if (path.contains(".html")) {
        responseHtml(path, outputStream);
      } else if (path.startsWith("/css") || path.startsWith("/images") || path.startsWith("/js")) {
        responseFile(outputStream, path);
      } else {
        switch (path) {
          case "/server/login": {
            //name=123&pwd=123
            Map<String, String> formData = mbmRequest.getFormData();
            // TODO 用户登录
            System.out.println(formData);
            responseRedirect(outputStream, mbmRequest, "/bill_list.html");
          }
          break;
          case "/server/user/modify":
            Map<String, String> formData = mbmRequest.getFormData();
            // TODO 添加用户
            responseRedirect(outputStream, mbmRequest, "/user_list.html");
            break;
          case "/server/user/list":
            List<User> users = new ArrayList<>();
            User e = new User();
            e.setName("张三");
            e.setUserType(1);
            User l = new User();
            l.setName("李四");
            l.setUserType(0);
            users.add(e);
            users.add(l);

            responseJson(outputStream, users);
            break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void responseJson(DataOutputStream outputStream, Object o) throws IOException {
    String data = JSONObject.toJSONString(o);

    byte[] bytes = data.getBytes();
    String contentLength = "Content-Length: " + bytes.length;
    outputStream.writeBytes("HTTP/1.1 200 OK\r\n");
    outputStream.writeBytes("Content-Type: application/json;charset=UTF-8\r\n");
    outputStream.writeBytes(contentLength);
    outputStream.writeBytes("\r\n");
    outputStream.writeBytes("\r\n");
    outputStream.write(bytes);
  }

  private void responseRedirect(DataOutputStream out, MbmRequest request, String path)
      throws IOException {
    out.writeBytes("HTTP/1.1 302 Found");
    out.writeBytes("\r\n");
    out.writeBytes("Location: " + "http://" + request.getHost() + path);
    out.writeBytes("\r\n");
  }

  private void responseHtml(String path, DataOutputStream outputStream) throws IOException {
    InputStream resourceAsStream = null;
    try {
      resourceAsStream = HttpServerBakOther.class.getClassLoader()
          .getResourceAsStream("pages" + path);
      if (resourceAsStream == null) {
        resourceAsStream = HttpServerBakOther.class.getClassLoader()
            .getResourceAsStream("pages/404.html");
      }
      String contentLength = "Content-Length: " + resourceAsStream.available();
      outputStream.writeBytes("HTTP/1.1 200 OK\r\n");
      outputStream.writeBytes("Content-Type: text/html; charset=utf-8\r\n");
      outputStream.writeBytes(contentLength);
      outputStream.writeBytes("\r\n");
      outputStream.writeBytes("\r\n");
      outputStream.write(resourceAsStream.readAllBytes());
    } finally {
      if (resourceAsStream != null) {
        resourceAsStream.close();
      }
    }
  }

  private void responseFile(DataOutputStream outputStream, String path) throws IOException {
    InputStream resourceAsStream = HttpServerBakOther.class.getClassLoader()
        .getResourceAsStream("pages" + path);
    if (resourceAsStream == null) {
      // TODO Exception
      System.err.println("资源不存在");
      return;
    }
    String contentLength = "Content-Length: " + resourceAsStream.available();
    outputStream.writeBytes("HTTP/1.1 200 OK\r\n");
    outputStream.writeBytes(contentLength);
    outputStream.writeBytes("\r\n");
    outputStream.writeBytes("\r\n");
    outputStream.write(resourceAsStream.readAllBytes());
  }

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(5000);

    while (true) {
      Socket accept = serverSocket.accept();
      HttpServerBakOther server = new HttpServerBakOther(accept);
      server.start();
    }

    // "HTTP/1.1 200 OK\r\n"
    // "Content-Type: text/html; charset=utf-8\r\n"
    // "Content-Length: 1234\r\n"
    // "\r\n"
    // data

    // out.writeBytes("HTTP/1.1 200 OK");
    // out.writeBytes("\r\n");
    // out.writeBytes("Content-Type: text/html; charset=utf-8");
    // out.writeBytes("\r\n");
    // out.writeBytes(("Content-Length: " + resourceAsStream.available()));
    // out.writeBytes("\r\n");
    // out.writeBytes("\r\n");
  }
}
