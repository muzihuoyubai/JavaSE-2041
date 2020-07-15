package club.banyuan.mbm.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpServer1 {

  public static void main(String[] args) throws IOException {
    /**
     * 从classpath读取文件，开启文件的输入流
     *
     * getResourceAsStream 接收一个路径，相对于classpath的路径
     */
    // InputStream resourceAsStream = HttpServer.class.getClassLoader()
    //     .getResourceAsStream("pages/login.html");

    ServerSocket serverSocket = new ServerSocket(5000);

    while (true) {
      // 阻塞，直到浏览器发送请求，接收到浏览器请求之后，返回socket对象
      Socket clientSocket = serverSocket.accept();

      // 开启浏览器的流，获取浏览器发送的数据
      InputStream inputStream = clientSocket.getInputStream();
      System.out.println(clientSocket.getInetAddress().getHostAddress());

      // 为了有更好的处理方法，将字节流转换为字符流
      // InputStreamReader 字节流到字符流的转换
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      // "      \n"
      // 1231u23oi1uoiadsf;lkjlk\n
      // askjdfhlakjef;aekjf;aelwf\n
      // 123123adfjaw;efk
      // readLine会从流里面读取一行，
      String line = bufferedReader.readLine();
      if (line == null) {
        // 建立tcp连接之后，通常不会读取到null，除非连接关闭
        System.err.println("解析失败");
        continue;
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

      // /pages/css/style.css

      // "/pages".subString(1) = > pages
      // "/pages".subString(1,2) =>

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

      InputStream resourceAsStream = HttpServer1.class.getClassLoader()
          .getResourceAsStream(resourcePath);

      if (resourceAsStream == null) {
        resourceAsStream = HttpServer1.class.getClassLoader()
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
      clientSocket.close();
    }

    // response header
    // HTTP/1.1 200 OK
    // Content-Type: text/html; charset=utf-8
    // Content-Length: 1234
    //
    // bytes

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
