package club.banyuan.shop;

public class Shop {

  private int inventory;

  public Shop(int inventory) {
    this.inventory = inventory;
  }

  // synchronized this 等价于  synchronize 方法
  // public void buy(Customer customer) {
  //   synchronized (this) {
  //     customer.sitdown();
  //     inventory--;
  //     System.out.println(customer.getName() + "购买一件商品");
  //   }
  // }

  synchronized public void buy(Customer customer) {
    customer.sitdown();
    inventory--;
    System.out.println(customer.getName() + "购买一件商品");
  }

  public int getInventory() {
    return inventory;
  }

  public void setInventory(int inventory) {
    this.inventory = inventory;
  }
}
