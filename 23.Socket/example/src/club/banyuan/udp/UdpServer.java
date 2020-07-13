package club.banyuan.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {

  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket(5000);

    byte[] buf = new byte[0x10000];
    DatagramPacket packet = new DatagramPacket(buf, buf.length);
    socket.receive(packet);

    System.out.println(packet.getAddress().getHostAddress());
    System.out.println(packet.getPort());
    // [1,2,3,4,5,6,7,8,9]
    // 0,3 => 1,2,3
    // 3,5 => 4,5,6,7,8
    String msg = new String(packet.getData(), 0, packet.getLength());
    System.out.println(msg);

    // String s = "123456";
    // System.out.println(s.getBytes().length);
    //
    // byte[] bytes = s.getBytes();
    // System.out.println(new String(bytes, 2, 3));

  }
}
