package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UdpServerRefine extends Thread {

  private DatagramSocket datagramSocket;

  public UdpServerRefine(DatagramSocket datagramSocket) {
    this.datagramSocket = datagramSocket;
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
    System.out.println("服务器停止");
  }

  public static void main(String[] args) {
    DatagramSocket datagramSocket = null;
    try {
      datagramSocket = new DatagramSocket(5000);
    } catch (SocketException e) {
      System.out.println(e);
      return;
    }
    UdpServerRefine server = new UdpServerRefine(datagramSocket);
    server.start();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      if ("quit".equalsIgnoreCase(scanner.nextLine())) {
        datagramSocket.close();
        break;
      }
    }
  }

}
