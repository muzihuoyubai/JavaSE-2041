package club.banyuan.shop;

import java.util.Random;

public class Customer extends Thread {

  private Shop shop;
  private static final Random rand = new Random();

  public Customer(Shop shop, String name) {
    super(name);
    this.shop = shop;
  }

  @Override
  public void run() {
    while (true) {
      shop.buy(this);
      sitdown();
    }
  }

  public int consume() {
    int i = rand.nextInt(10) + 1;
    System.out.println(getName() + "消费了" + i);
    return i;
  }

  public void sitdown() {
    System.out.println("休息一会");
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
