public class StatusDemo {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          System.out.println("线程启动：" + Thread.currentThread().getState());
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    System.out.println("线程对象创建，还未调用start：" + thread.getState());
    thread.start();
    Thread.sleep(100);
    System.out.println("线程休眠：" + thread.getState());
    thread.join();
    System.out.println("线程结束：" + thread.getState());
  }
}
