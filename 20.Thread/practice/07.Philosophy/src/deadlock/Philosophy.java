package deadlock;

import java.util.Random;

public class Philosophy extends Thread {

  private static final Random rand = new Random();

  public Philosophy(String name, Chopsticks left, Chopsticks right) {
    super(name);
    this.left = left;
    this.right = right;
  }

  private Chopsticks left;
  private Chopsticks right;


  @Override
  public void run() {
    while (true) {
      if (rand.nextBoolean()) {
        eat();
      } else {
        think();
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

  private void eat() {
    System.out.println(getName() + "准备吃饭");
    this.left.take(this);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    this.right.take(this);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(getName() + "吃饭完成");
    this.right.put(this);
    this.left.put(this);
  }
}
