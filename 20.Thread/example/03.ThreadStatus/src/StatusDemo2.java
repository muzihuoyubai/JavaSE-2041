public class StatusDemo2 extends Thread {

  private Thread thread;

  public StatusDemo2(Thread thread) {
    this.thread = thread;
  }

  @Override
  public void run() {
    try {
      System.out.println("线程启动：" + Thread.currentThread().getState());
      Thread.sleep(1000);
      System.out.println("主线程状态:" + thread.getState());
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new StatusDemo2(Thread.currentThread());
    System.out.println("线程对象创建，还未调用start：" + thread.getState());
    thread.start();
    Thread.sleep(100);
    System.out.println("线程休眠：" + thread.getState());
    thread.join();
    System.out.println("线程结束：" + thread.getState());
  }
}
