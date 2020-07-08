package club.banyuan;

public class StopDemo extends Thread {

  private Demo demo;

  public StopDemo(Demo demo) {
    this.demo = demo;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    demo.stopRunning();
    System.out.println("停止demo");
  }
}
