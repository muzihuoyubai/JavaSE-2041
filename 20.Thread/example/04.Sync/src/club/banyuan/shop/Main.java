package club.banyuan.shop;

public class Main {

  public static void main(String[] args) {
    Shop shop = new Shop(20);
    Customer zhangsan = new Customer(shop, "张三");
    Customer lisi = new Customer(shop, "李四");
    zhangsan.start();
    lisi.start();
    try {
      zhangsan.join();
      lisi.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("=============");
    System.out.println(shop.getInventory());
  }
}
