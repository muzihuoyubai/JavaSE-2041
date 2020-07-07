package club.banyuan.staticmethod;

public class Shop {

  private static int inventory = 20;

  // synchronized public static void buy(Customer customer) {
  //   customer.sitdown();
  //   inventory--;
  //   System.out.println(customer.getName() + "购买一件商品");
  // }

  public static void buy(Customer customer) {
    synchronized (Shop.class) {
      customer.sitdown();
      inventory--;
      System.out.println(customer.getName() + "购买一件商品");
    }

  }

  public static int getInventory() {
    return inventory;
  }

  public static void setInventory(int inventory) {
    Shop.inventory = inventory;
  }
}
