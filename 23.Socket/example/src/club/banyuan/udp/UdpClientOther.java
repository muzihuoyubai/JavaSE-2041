package club.banyuan.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClientOther {

  public static void main(String[] args) {
    try {
      DatagramSocket datagramSocket = new DatagramSocket();
      String word = "广播";
      int count = 1;
      while (true) {
        try {
          String target = word + "第" + count + "次";
          count++;
          byte[] bytes = target.getBytes();
          DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,
              InetAddress.getByName("192.168.9.255"), 5000);
          datagramSocket.send(datagramPacket);

          datagramPacket = new DatagramPacket(bytes, bytes.length,
              InetAddress.getByName("192.168.10.255"), 5000);
          datagramSocket.send(datagramPacket);

          datagramPacket = new DatagramPacket(bytes, bytes.length,
              InetAddress.getByName("192.168.11.255"), 5000);
          datagramSocket.send(datagramPacket);

          datagramPacket = new DatagramPacket(bytes, bytes.length,
              InetAddress.getByName("192.168.8.255"), 5000);
          datagramSocket.send(datagramPacket);
          System.out.println("发送数据：" + target);
          Thread.sleep(5000);
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
          try {
            Thread.sleep(5000);
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
