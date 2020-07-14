package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UdpServer extends Thread {

  private DatagramSocket datagramSocket;

  public UdpServer() {
    try {
      this.datagramSocket = new DatagramSocket(5000);
    } catch (SocketException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    try {
      System.out.println("upd服务端启动");
      byte[] buf = new byte[65536];
      while (true) {
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket);
        System.out
            .println("收到消息：" + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    UdpServer server = new UdpServer();
    server.start();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      if ("quit".equalsIgnoreCase(scanner.nextLine())) {
        System.exit(0);
      }
    }
  }

}
