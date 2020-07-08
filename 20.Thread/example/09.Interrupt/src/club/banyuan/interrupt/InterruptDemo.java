package club.banyuan.interrupt;

public class InterruptDemo extends Thread {

  /**
   * isInterrupted 实例方法，返回中断标识 true——被中断 false——未被中断
   * interrupted 静态方法，使用Thread.interrupted，返回中断标识，并且在调用结束后重置中断标识为false
   * interrupt 实例方法，将调用该方法的线程对象中断标识置为true
   */
  @Override
  public void run() {

    while (!Thread.currentThread().isInterrupted()) {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        // System.out.println(Thread.currentThread().isInterrupted());
        // System.out.println("睡眠被中断");
      }
    }
    System.out.println("线程退出");

  }

  public static void main(String[] args) throws InterruptedException {
    InterruptDemo interruptDemo = new InterruptDemo();
    interruptDemo.start();

    Thread.sleep(1000);
    interruptDemo.join();
    synchronized (InterruptDemo.class) {
      InterruptDemo.class.wait();
    }
    interruptDemo.interrupt();
  }
}
