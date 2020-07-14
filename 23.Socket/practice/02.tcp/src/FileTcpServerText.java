import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTcpServerText {

  public static void main(String[] args) {
    // String path = "/Users/liyi/works/repos/banyuan/JavaSE-2041/23.Socket/test.json";
    try {
      ServerSocket serverSocket = new ServerSocket(5000);
      System.out.println("服务器启动");
      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println(socket.getInetAddress().getHostAddress() + "connected...");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        boolean isEncode = Boolean.parseBoolean(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int lines = Integer.parseInt(reader.readLine());
        System.out.println("行数：" + lines);
        int count = lines;
        while (count > 0) {
          if (isEncode) {
            stringBuilder.append(Encode.caesarEncode(reader.readLine()));
          } else {
            stringBuilder.append(Decode.caesarDecode(reader.readLine()));
          }
          stringBuilder.append("\n");
          count--;
        }
        System.out.println("接收完成");

        BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream()));
        writer.write(lines + "");
        writer.newLine();
        writer.write(stringBuilder.toString());
        writer.flush();
        System.out.println("发送完成");
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
