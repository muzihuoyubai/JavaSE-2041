/**
 * 线程状态
 * NEW(初始):尚未启动的线程的线程状态。
 * RUNNABLE(运行):可运行线程的线程状态。
 * BLOCKED(阻塞):线程的线程状态被阻止，正在等待监视器锁。
 * WAITING(等待):等待线程的线程状态。
 * TIMED_WAITING(超时等待):具有指定等待时间的等待线程的线程状态。
 * TERMINATED(终止):终止线程的线程状态。
 */
class OtherThread implements Runnable {

  public void run() {
    // 当thread2开始后，执行此代码进入sleep，变更为TIMED_WAITING状态
    Test.sleep(1500);

    // 线程2代码执行到此处时，线程1的代码执行到了 thread2.join();（74行）
    System.out.println("线程1中调用了线程2的join()方法，thread1的状态 -" +
        Test.thread1.getState());
    Test.sleep(200);
  }
}

public class Test implements Runnable {

  public static Thread thread1;
  public static final Object lock = new Object();

  public static void main(String[] args) {
    thread1 = new Thread(new Test());

    // thread1已经创建，并且当前处于NEW
    System.out.println("创建线程1 - " + thread1.getState());
    thread1.start();

    // thread1变更为RUNNABLE
    System.out.println("在线程1上调用.start()方法后的状态 - " +
        thread1.getState());
  }

  public void run() {
    Thread thread2 = new Thread(new OtherThread());

    // 线程2已经创建，并且当前处于NEW
    System.out.println("创建线程2 - " + thread2.getState());
    thread2.start();

    // 线程2变更为RUNNABLE
    System.out.println("在线程2上调用.start()方法后的状态 - " +
        thread2.getState());

    sleep(200);
    System.out.println("线程2的run中执行 .sleep() 方法过程中的状态 - " +
        thread2.getState());

    try {
      // 等待线程2执行结束， join中间传入时间，则线程1的状态为TIMED_WAITING，否则为WAITING
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("线程2执行完成后的状态 - " +
        thread2.getState());

    Thread thread3 = new Thread(new BlockTestThread());
    Thread thread4 = new Thread(new BlockTestThread());
    thread3.start();
    sleep(200);
    thread4.start();
    // 确保线程4 等待线程3 释放锁，让线程4进入到 BLOCK状态
    sleep(200);
    System.out.println("线程4等待锁释放的状态 - " + thread4.getState());

  }

  public static void sleep(long time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

class BlockTestThread implements Runnable {

  @Override
  public void run() {
    lockMethod();
  }

  public void lockMethod() {
    synchronized (Test.lock) {
      Test.sleep(1000);
    }
  }
}