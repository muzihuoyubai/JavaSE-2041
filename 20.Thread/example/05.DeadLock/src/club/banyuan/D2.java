package club.banyuan;

public class D2 extends Thread {

  @Override
  public void run() {
    System.out.println("线程D2启动");
    synchronized (CommonResource.o2) {
      System.out.println("线程D2获取锁o2");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("线程D2准备获取锁o1");
      synchronized (CommonResource.o1) {

      }
    }
  }
}
