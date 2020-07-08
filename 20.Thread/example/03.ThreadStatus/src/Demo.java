public class Demo {

  private static Object lock = new Object();

  public static void main(String[] args) throws InterruptedException {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          try {
            Thread.sleep(10000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

      }
    };

    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);


    thread1.start();
    Thread.sleep(200);
    thread2.start();
    Thread.sleep(200);
    System.out.println("Thread1 state:" + thread1.getState());
    System.out.println("Thread2 state:" + thread2.getState());

    Thread thread3 = new Thread(new Runnable() {
      @Override
      public void run() {
        Thread thread4 = new Thread(new Runnable() {
          @Override
          public void run() {
            try {
              Thread.sleep(50000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        });
        thread4.start();
        try {
          thread4.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    thread3.start();

    Thread.sleep(200);

    System.out.println("线程3状态：" + thread3.getState());
  }
}
