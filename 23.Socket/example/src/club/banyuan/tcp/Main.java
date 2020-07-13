package club.banyuan.tcp;

public class Main {

  public static void main(String[] args) {
    int a = 12345;
    byte[] parse = parse(12345);
    int parse1 = parse(parse);
    System.out.println(parse1);
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

  public static byte[] parse(int target) {
    byte[] bytes = new byte[4];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) (target >> 8 * (3 - i));
    }
    return bytes;
  }
}
