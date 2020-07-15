package club.banyuan.mbm.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 开启多线程
 */
public class HttpServer2 {

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(5000);

    while (true) {
      // 阻塞，直到浏览器发送请求，接收到浏览器请求之后，返回socket对象
      Socket clientSocket = serverSocket.accept();
      // 创建线程类，需要一个线程类处理一次浏览器请求
      SocketHandler socketHandler = new SocketHandler(clientSocket);
      socketHandler.start();
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
