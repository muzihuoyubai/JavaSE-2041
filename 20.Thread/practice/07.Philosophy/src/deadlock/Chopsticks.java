package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopsticks {

  private boolean isToken;
  private Lock lock = new ReentrantLock();
  private int code;

  public Chopsticks(int code) {
    this.code = code;
  }

  public void take(Philosophy philosophy) {
    System.out.println(philosophy.getName() +"准备拿起筷子" + code);
    lock.lock();
    isToken = true;
    System.out.println(philosophy.getName() +"拿起筷子" + code);
  }

  public void put(Philosophy philosophy) {
    System.out.println(philosophy.getName() +"准备放下筷子" + code);
    isToken = false;
    lock.unlock();
    System.out.println(philosophy.getName() +"放下筷子" + code);
  }
}
