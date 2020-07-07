package club.banyuan.staticmethod;

public class Main {

  public static void main(String[] args) {
    // Shop shop = new Shop(20);
    Customer zhangsan = new Customer("张三");
    Customer lisi = new Customer("李四");
    zhangsan.start();
    lisi.start();
    try {
      zhangsan.join();
      lisi.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("=============");
    System.out.println(Shop.getInventory());
  }
}
