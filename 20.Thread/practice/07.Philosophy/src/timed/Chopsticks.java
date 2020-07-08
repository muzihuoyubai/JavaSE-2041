package timed;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopsticks {

  private boolean isToken;
  private Lock lock = new ReentrantLock();
  private int code;

  public Chopsticks(int code) {
    this.code = code;
  }

  public boolean take(Philosophy philosophy) throws InterruptedException {
    System.out.println(philosophy.getName() + "准备拿起筷子" + code);
    if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
      System.out.println(philosophy.getName() + "拿起筷子" + code);
      isToken = true;
      return true;
    } else {
      System.out.println(philosophy.getName() + "没有拿到筷子" + code);
      return false;
    }
  }

  public void put(Philosophy philosophy) {
    if (isToken) {
      System.out.println(philosophy.getName() + "准备放下筷子" + code);
      lock.unlock();
      isToken = false;
      System.out.println(philosophy.getName() + "放下筷子" + code);
    }
  }
}
