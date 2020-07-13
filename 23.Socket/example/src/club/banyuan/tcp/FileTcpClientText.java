package club.banyuan.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class FileTcpClientText {

  public static void main(String[] args) {
    String path = "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/example/08.JsonDemo/test.json";
    try {
      Socket socket = new Socket("127.0.0.1", 5000);
      System.out.println("建立连接");
      File file = new File(path);
      BufferedReader reader = new BufferedReader(new FileReader(file));
      StringBuilder builder = new StringBuilder();

      int count = 0;
      String line = reader.readLine();
      while (line != null) {
        count++;
        System.out.println("写入：" + line);
        builder.append(line);
        builder.append(System.lineSeparator());
        line = reader.readLine();
        // writer.write(line);
        // writer.newLine();
        // writer.flush();
        // line = reader.readLine();
      }

      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      writer.write(count + "");
      writer.newLine();
      writer.write(builder.toString());
      writer.flush();

      // FileInputStream fileInputStream = new FileInputStream(file);
      // byte[] bytes = new byte[1024];
      // int count = fileInputStream.read(bytes);
      // while (count > 0) {
      //   outputStream.write(bytes, 0, count);
      //   count = fileInputStream.read(bytes);
      // }
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
