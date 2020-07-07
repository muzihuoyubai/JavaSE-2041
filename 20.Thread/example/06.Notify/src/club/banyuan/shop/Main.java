package club.banyuan.shop;

public class Main {

  public static void main(String[] args) {
    Shop shop = new Shop(20);
    Customer zhangsan = new Customer(shop, "张三");
    Customer lisi = new Customer(shop, "李四");
    zhangsan.start();
    lisi.start();

    Factory f1 = new Factory(shop, "工厂1");
    Factory f2 = new Factory(shop, "工厂2");

    f1.start();
    f2.start();

    // try {
    //   zhangsan.join();
    //   lisi.join();
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    // System.out.println("=============");
    // System.out.println(shop.getInventory());
  }
}
