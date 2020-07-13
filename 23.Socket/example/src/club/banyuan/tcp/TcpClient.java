package club.banyuan.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 5000);
      System.out.println("建立连接");
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write("你好".getBytes());
      System.out.println("发送数据成功");
      InputStream inputStream = socket.getInputStream();
      byte[] bytes = new byte[1024];
      int count = inputStream.read(bytes);
      System.out.println("读取数据");
      // while (count > 0) {
      System.out.println(new String(bytes, 0, count));
      // Thread.sleep(100000);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
