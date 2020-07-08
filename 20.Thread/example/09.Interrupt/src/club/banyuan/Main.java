package club.banyuan;

public class Main {

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
}
