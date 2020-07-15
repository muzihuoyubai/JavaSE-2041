package club.banyuan.mbm.demo;

public class SubStringDemo {

  public static void main(String[] args) {
    // [起始下标，结束下标)
    System.out.println("01234567".substring(1, 2)); // 1
    // 起始下标开始 直到字符串结尾
    System.out.println("01234567".substring(1)); // 1234567
  }
}
