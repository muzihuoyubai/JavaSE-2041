package club.banyuan;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpClient {

  public static void main(String[] args) throws SocketException {
    System.out.println("客户端启动..");
    Scanner scanner = new Scanner(System.in);
    // 127.0.0.1 123 你好
    // {127.0.0.1, 123, 你好}
    DatagramSocket socket = new DatagramSocket();
    while (true) {
      String input = scanner.nextLine();
      if ("quit".equalsIgnoreCase(input)) {
        break;
      }
      String[] targetStr = input.split(" ");
      try {
        byte[] bytes = targetStr[2].getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
            InetAddress.getByName(targetStr[0]),
            Integer.parseInt(targetStr[1]));
        socket.send(packet);
      } catch (Exception e) {
        System.out.println("输入不合法，请重新输入！");
      }
    }

    socket.close();

  }

}
