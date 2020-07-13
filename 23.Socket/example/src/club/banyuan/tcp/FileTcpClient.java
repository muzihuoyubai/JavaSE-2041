package club.banyuan.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileTcpClient {

  public static void main(String[] args) {
    String path = "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/doc/WIN.mp3";
    try {
      Socket socket = new Socket("127.0.0.1", 5000);
      System.out.println("建立连接");
      File file = new File(path);

      OutputStream outputStream = socket.getOutputStream();

      int length = (int) file.length();

      outputStream.write(parse(length));
      FileInputStream fileInputStream = new FileInputStream(file);
      byte[] bytes = new byte[1024];
      int count = fileInputStream.read(bytes);
      while (count > 0) {
        outputStream.write(bytes, 0, count);
        count = fileInputStream.read(bytes);
      }
      Thread.sleep(100000);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  // 00000000 11111111 00000000 1111111
  public static byte[] parse(int target) {
    byte[] bytes = new byte[4];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) (target >> 8 * (3 - i));
    }
    return bytes;
  }
}
