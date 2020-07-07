package club.banyuan;

public class D1 extends Thread {

  @Override
  public void run() {
    System.out.println("线程D1启动");
    synchronized (CommonResource.o1) {
      System.out.println("线程D1获取锁o1");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("线程D1准备获取锁o2");
      synchronized (CommonResource.o2) {
        
      }
    }
  }
}
