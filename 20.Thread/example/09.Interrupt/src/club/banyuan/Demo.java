package club.banyuan;

public class Demo extends Thread {

  private volatile boolean isRunning = true;

  public boolean isRunning() {
    return isRunning;
  }

  public void setRunning(boolean running) {
    isRunning = running;
  }

  public void stopRunning() {
    isRunning = false;
  }

  public static void main(String[] args) {
    Demo demo = new Demo();
    demo.start();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // demo.setRunning(false);
    StopDemo stopDemo = new StopDemo(demo);
    stopDemo.start();
  }


  @Override
  public void run() {
    while (isRunning) {
      System.out.println("运行中。。。");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("demo运行结束");
  }
}
