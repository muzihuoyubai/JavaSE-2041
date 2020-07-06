public class ThreadDemo implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      System.out.println(Thread.currentThread().getName() + i);
      // Thread.yield();
    }
  }

  public static void main(String[] args) {
    ThreadDemo myRunnable = new ThreadDemo();
    Thread thread = new Thread(myRunnable, "线程1");
    thread.setPriority(Thread.MIN_PRIORITY);
    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ThreadDemo myRunnable2 = new ThreadDemo();
    Thread thread1 = new Thread(myRunnable2, "线程2");
    thread1.setPriority(Thread.MAX_PRIORITY);
    thread1.start();

    // System.out.println(Thread.currentThread().getName());
    // System.out.println(Thread.currentThread().getPriority());
    // System.out.println(Thread.currentThread().getId());
    // System.out.println(Thread.currentThread().isAlive());
    // System.out.println(Thread.currentThread().isDaemon());
    // System.out.println(Thread.currentThread().isInterrupted());

    try {
      System.out.println("准备休眠1s");
      Thread.sleep(10000);
      System.out.println("休眠结束");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Thread.yield();
  }
}
