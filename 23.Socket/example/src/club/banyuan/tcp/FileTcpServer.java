package club.banyuan.tcp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTcpServer {

  public static void main(String[] args) {
    String path = "/Users/liyi/works/repos/banyuan/JavaSE-2041/23.Socket/WIN.mp3";
    try {
      ServerSocket serverSocket = new ServerSocket(5000);
      System.out.println("服务器启动");
      Socket socket = serverSocket.accept();
      System.out.println(socket.getInetAddress().getHostAddress() + "connected...");

      // 4 byte = 文件长度
      // 后续接收 文件长度 这么长的byte内容
      InputStream inputStream = socket.getInputStream();
      byte[] lengthBytes = new byte[4];
      inputStream.read(lengthBytes);
      int len = parse(lengthBytes);
      System.out.println("文件长度：" + len);
      FileOutputStream fileOutputStream = new FileOutputStream(path);
      byte[] buf = new byte[1024];
      int count = inputStream.read(buf, 0, Math.min(buf.length, len));
      while (len > 0) {
        fileOutputStream.write(buf, 0, count);
        len -= count;
        count = inputStream.read(buf, 0, Math.min(buf.length, len));
      }

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
