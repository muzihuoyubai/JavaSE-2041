public class StartVsRun {

  public static void main(String[] args) {
    Thread a = new Thread(() -> {
      for (int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName() + i);
        Thread.yield();
      }
    }, "线程a");

    Thread b = new Thread(() -> {
      for (int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName() + i);
        Thread.yield();
      }
    }, "线程b");
    a.start();
    b.start();
    // a.run();
    // b.run();
  }
}
