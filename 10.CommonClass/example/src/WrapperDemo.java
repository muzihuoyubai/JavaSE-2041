package club.banyuan;

public class WrapperDemo {

  public static void main(String[] args) {
    Integer w1 = Integer.valueOf(10);
    Integer w2 = new Integer(10); // 不推荐使用这种方式创建包装类对象。

    // 自动装箱, 相当于 Integer w3 = Integer.valueOf(10);
    Integer w3 = 10;

    int p1 = w1.intValue();

    // 自动拆箱，相当于 int p2 = w1.intValue();
    int p2 = w1;

    Integer w4 = null;
    // int p3 = w4; // NullPointerException
  }

}
