import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo extends Thread {

  public Demo(String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread() == this);
    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // System.out.println(getName() + "启动");
    // System.out.println(Thread.currentThread().getName() + "启动");
  }

  static int a = 15;

  public static void main(String[] args) {

    Demo demo = new Demo("线程1");
    // demo.start();

    // Thread thread = new Thread(new Runnable() {
    //   @Override
    //   public void run() {
    //     System.out.println("启动");
    //   }
    // });

    // ExecutorService executorService = Executors.newCachedThreadPool();
    // executorService.submit(demo);
    //
    // executorService.shutdown();
    // // 向线程池中启动的线程传递中断标志
    // // executorService.shutdownNow();
    //
    // ExecutorService executorService1 = Executors.newFixedThreadPool(10);
    // for (int i = 0; i < 20; i++) {
    //   int index = i; // effectively final
    //   executorService1.submit(new Runnable() {
    //     @Override
    //     public void run() {
    //       System.out.println("线程启动" + index);
    //       try {
    //         Thread.sleep(10000);
    //       } catch (InterruptedException e) {
    //         e.printStackTrace();
    //       }
    //     }
    //   });
    // }

    ExecutorService executorService2 = Executors.newSingleThreadExecutor();

    Future<String> submit = executorService2.submit(new MyCallable());
    try {
      String s = submit.get();
      System.out.println(s);
    } catch (InterruptedException | ExecutionException e) {
      System.out.println(e.getMessage());
    }
  }
}
