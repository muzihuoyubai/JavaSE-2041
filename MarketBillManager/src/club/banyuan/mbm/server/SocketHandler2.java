package club.banyuan.mbm.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class SocketHandler2 extends Thread {

  private Socket clientSocket;

  public SocketHandler2(Socket clientSocket) {
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

      while (line != null && line.length() != 0) {
        if (line.startsWith("Host:")) {
          mbmRequest.setHost(line.replace("Host: ", ""));
        }
        System.out.println(line);
        line = bufferedReader.readLine();
      }

      System.out.println(mbmRequest);

      String resourcePath = mbmRequest.getPath();
      if (resourcePath.startsWith("/")) {
        resourcePath = resourcePath.substring(1);
      }

      if (resourcePath.length() == 0) {
        resourcePath = "pages/login.html";
      } else if (resourcePath.startsWith("css") || resourcePath.startsWith("images") || resourcePath
          .startsWith("js")) {
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
}
