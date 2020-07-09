package club.banyuan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounter {

  static int counter = 0;
  static AtomicInteger atomicInteger = new AtomicInteger(0);


  public static void reset() {
    atomicInteger = new AtomicInteger(0);
  }

  public static int increment(int numThreads, int numIncrementsPerThread)
      throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
    for (int i = 0; i < numThreads; i++) {
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(50);
          } catch (InterruptedException e) {
            // e.printStackTrace();
          }
          atomicInteger.addAndGet(numIncrementsPerThread);
          // synchronized (SharedCounter.class) {
          //   counter += numIncrementsPerThread;
          // }
        }
      });
    }
    // Thread.sleep(2000);
    executorService.shutdownNow();
    executorService.awaitTermination(10, TimeUnit.DAYS);
    return atomicInteger.get();
  }
}
