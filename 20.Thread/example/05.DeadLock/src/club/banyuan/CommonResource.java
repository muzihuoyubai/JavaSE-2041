package club.banyuan;

public class CommonResource {

  public static final Object o1 = new Object();
  public static final Object o2 = new Object();

  public static void main(String[] args) {
    D1 d1 = new D1();
    D2 d2 = new D2();
    d1.start();
    d2.start();
  }
}
