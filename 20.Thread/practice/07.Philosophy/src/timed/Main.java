package timed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  // 扩展哲学家类，记录吃饭、思考次数的功能、记录饿了多少次肚子
  // main方法执行一分钟后，停止所有哲学家线程，打印所有哲学家的记录结果
  static Chopsticks[] chopsticks = new Chopsticks[5];
  static Philosophy[] philosophies = new Philosophy[5];

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 0; i < chopsticks.length; i++) {
      chopsticks[i] = new Chopsticks(i + 1);
    }
    // 0 - 0 1   1 - 1 2   2 - 2 3  3 - 3 4  4 - 4 0
    for (int i = 0; i < philosophies.length; i++) {
      philosophies[i] = new TimedPhilosophy("哲学家" + (i + 1), chopsticks[i],
          chopsticks[(i + 1) % 5]);
      executorService.submit(philosophies[i]);
    }

    Thread.sleep(1000 * 20);

    executorService.shutdownNow();
    executorService.awaitTermination(10, TimeUnit.SECONDS);

    for (Philosophy philosophy : philosophies) {
      System.out.println(philosophy);
    }

  }

}
