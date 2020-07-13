package club.banyuan.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {

  public static void main(String[] args) throws IOException {

    DatagramSocket socket = new DatagramSocket(5000);
    String word = "hello";
    byte[] bytes = word.getBytes();
    // 创建数据包， 需要指定目的地的ip地址和端口号
    DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
        InetAddress.getByName("127.0.0.1"), 3306);
    socket.send(packet);
    socket.close();
  }


}
