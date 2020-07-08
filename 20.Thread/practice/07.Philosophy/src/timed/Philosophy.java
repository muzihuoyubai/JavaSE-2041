package timed;

import java.util.Random;
import java.util.concurrent.Callable;

public class Philosophy implements Callable<String> {

  private static final Random rand = new Random();

  String name;



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Philosophy(String name, Chopsticks left, Chopsticks right) {
    // super(name);
    this.left = left;
    this.right = right;
  }

  private Chopsticks left;
  private Chopsticks right;


  // @Override
  public void run() {
    while (true) {
      try {
        if (rand.nextBoolean()) {
          eat();
        } else {
          think();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  private void think() {
    System.out.println(getName() + "准备思考");
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(getName() + "思考完成");
  }

  private void eat() throws InterruptedException {
    System.out.println(getName() + "准备吃饭");
    if (!this.left.take(this)) {
      System.out.println(getName() +"饿肚子");
      return;
    }
    Thread.sleep(500);
    if (!this.right.take(this)) {
      this.left.put(this);
      System.out.println(getName() + "饿肚子");
      return;
    }
    Thread.sleep(500);
    System.out.println(getName() + "吃饭完成");
    this.right.put(this);
    this.left.put(this);
  }

  @Override
  public String call() throws Exception {
    return null;
  }
}
