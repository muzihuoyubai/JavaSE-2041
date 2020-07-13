package club.banyuan.tcp;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTcpServerText {

  public static void main(String[] args) {
    String path = "/Users/liyi/works/repos/banyuan/JavaSE-2041/23.Socket/test.json";
    try {
      ServerSocket serverSocket = new ServerSocket(5000);
      System.out.println("服务器启动");
      Socket socket = serverSocket.accept();
      System.out.println(socket.getInetAddress().getHostAddress() + "connected...");

      // 4 byte = 文件长度
      // 后续接收 文件长度 这么长的byte内容
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      int lines = Integer.parseInt(reader.readLine());
      System.out.println("行数：" + lines);
      while (lines > 0) {
        System.out.println(reader.readLine());
        lines--;
      }
      System.out.println("接收完成");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int parse(byte[] bytes) {
    int rlt = 0;
    //  00000000 00000000 00000000 00000000
    //  11111111 00000000 00000000 00000000
    for (int i = 0; i < bytes.length; i++) {
      rlt |= ((int) bytes[i]) << 8 * (3 - i);
    }
    return rlt;
  }
}
