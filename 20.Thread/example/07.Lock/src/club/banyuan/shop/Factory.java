package club.banyuan.shop;

import java.util.Random;

public class Factory extends Thread {

  private Shop shop;
  public static final Random rand = new Random();

  public Factory(Shop shop, String name) {
    super(name);
    this.shop = shop;
  }

  public int produce() {
    int i = rand.nextInt(10) + 1;
    System.out.println(getName() + " 生产了" + i);
    return i;
  }

  @Override
  public void run() {
    while (true) {
      shop.store(this);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
