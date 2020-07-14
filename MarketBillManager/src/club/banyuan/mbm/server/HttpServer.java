package club.banyuan.mbm.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpServer {

  public static void main(String[] args) throws IOException {
    InputStream resourceAsStream = HttpServer.class.getClassLoader()
        .getResourceAsStream("pages/login.html");
    // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
    //
    // String line = bufferedReader.readLine();
    // while (line != null) {
    //   System.out.println(line);
    //   line = bufferedReader.readLine();
    // }

    ServerSocket serverSocket = new ServerSocket(5000);
    Socket accept = serverSocket.accept();
    InputStream inputStream = accept.getInputStream();
    System.out.println(accept.getInetAddress().getHostAddress());

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    String line = bufferedReader.readLine();
    if (line == null) {
      throw new RuntimeException("解析失败");
    }

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
    String contentLength = "Content-Length: " + resourceAsStream.available();

    OutputStream outputStream = accept.getOutputStream();
    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
    outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
    outputStream.write(contentLength.getBytes());
    outputStream.write("\r\n".getBytes());
    outputStream.write("\r\n".getBytes());
    outputStream.write(resourceAsStream.readAllBytes());

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
