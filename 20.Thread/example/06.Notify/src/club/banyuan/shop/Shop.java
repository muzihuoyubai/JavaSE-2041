package club.banyuan.shop;

public class Shop {

  private int inventory;
  private final static int MAX_STORE = 100;

  public Shop(int inventory) {
    this.inventory = inventory;
  }

  synchronized public void buy(Customer customer) {
    System.out.println(customer.getName() + "准备购买");
    if (inventory == 0) {
      // 这三个方法必须在synchronized代码块内部使用
      // 必须使用加锁的对象触发调用
      // try {
      // new Shop(123).wait(); // 代码运行到这里报错
      // } catch (InterruptedException e) {
      //   e.printStackTrace();
      // }
      // wait();
      // notify();
      System.out.println("通知工厂生产");
      notifyAll();
      try {
        System.out.println(customer.getName() + "等待。。。");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
      inventory -= customer.consume();
      if (inventory <= 0) {
        inventory = 0;
        return;
      }
      System.out.println("商店库存" + inventory);
    }
  }

  synchronized public void store(Factory factory) {
    System.out.println(factory.getName() + "准备生产");
    if (inventory < MAX_STORE) {
      inventory += factory.produce();
      if (inventory >= MAX_STORE) {
        inventory = MAX_STORE;
      }
      // System.out.println("商店库存" + inventory);
    } else {
      System.out.println("通知消费");
      notifyAll();
      try {
        System.out.println(factory.getName() + "等待。。。");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public int getInventory() {
    return inventory;
  }

  public void setInventory(int inventory) {
    this.inventory = inventory;
  }
}
