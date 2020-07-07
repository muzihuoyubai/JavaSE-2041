package club.banyuan.shop;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shop {

  private int inventory;
  private final static int MAX_STORE = 100;
  private Lock lock = new ReentrantLock();
  private Condition prodCondition = lock.newCondition();
  private Condition consumeCondition = lock.newCondition();

  public Shop(int inventory) {
    this.inventory = inventory;
  }

  public void buy(Customer customer) {

    lock.lock();
    System.out.println(customer.getName() + "准备购买");
    try {
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
        prodCondition.signalAll();
        System.out.println(customer.getName() + "等待。。。");
        try {
          consumeCondition.await(1000, TimeUnit.SECONDS);
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
    } finally {
      lock.unlock();
    }
  }

  public void store(Factory factory) {
    lock.lock();
    System.out.println(factory.getName() + "准备生产");
    try {
      if (inventory < MAX_STORE) {
        inventory += factory.produce();
        if (inventory >= MAX_STORE) {
          inventory = MAX_STORE;
        }
        // System.out.println("商店库存" + inventory);
      } else {
        System.out.println("通知消费");
        consumeCondition.signalAll();
        try {
          System.out.println(factory.getName() + "等待。。。");
          prodCondition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    } finally {
      lock.unlock();
    }
  }

  public int getInventory() {
    return inventory;
  }

  public void setInventory(int inventory) {
    this.inventory = inventory;
  }
}
