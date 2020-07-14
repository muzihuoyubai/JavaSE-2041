import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class FileTcpClientText {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        System.out.println("1.加密，2.解密");
        String input = scanner.nextLine();
        boolean isEncode;
        switch (input) {
          case "1":
            isEncode = true;
            break;
          case "2":
            isEncode = false;
            break;
          case "0":
            System.out.println("谢谢使用");
            return;
          default:
            System.out.println("输入不合法");
            continue;
        }
        System.out.println("输入文件的路径：");
        String path = scanner.nextLine();
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
          System.out.println("文件不合法");
          continue;
        }

        Socket socket = new Socket("127.0.0.1", 5000);
        System.out.println("建立连接");

        sendFile(socket, path, isEncode);
        receiveResult(socket);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  private static void sendFile(Socket socket, String path, boolean isEncode)
      throws IOException {
    File file = new File(path);
    BufferedReader reader = new BufferedReader(new FileReader(file));

    int count = 0;
    StringBuilder builder = new StringBuilder();
    String line = reader.readLine();
    while (line != null) {
      count++;
      System.out.println("写入：" + line);
      builder.append(line);
      builder.append(System.lineSeparator());
      line = reader.readLine();
    }

    reader.close();

    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    writer.write(isEncode + "");
    writer.newLine();
    writer.write(count + "");
    writer.newLine();
    writer.write(builder.toString());
    writer.flush();
  }

  private static void receiveResult(Socket socket) throws IOException {
    BufferedReader reader;
    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    int lines = Integer.parseInt(reader.readLine());
    System.out.println("行数：" + lines);
    while (lines > 0) {
      System.out.println(reader.readLine());
      lines--;
    }
    System.out.println("接收完成");
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
