package club.banyuan.udp;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class CountUdpPort {

  public static void main(String[] args) {
    // 0~65535
    List<Integer> count = new ArrayList<>();
    for (int i = 0; i < 65536; i++) {
      try {
        DatagramSocket datagramSocket = new DatagramSocket(i);
        datagramSocket.close();
      } catch (SocketException e) {
        count.add(i);
      }
    }

    System.out.println(count);

  }
}
