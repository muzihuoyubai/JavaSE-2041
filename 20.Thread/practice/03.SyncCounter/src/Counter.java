import java.util.Random;

public class Counter {

  private int value;

  /**
   * 将counter每次加1，加10次，时不时地休息一下。
   */
  public void count() {
    int count = 0;
    try {
      while (count < 10) {
        value++;
        // 生成一个0到5之间的随机数，使其睡眠时间在500ms左右
        Thread.sleep(500);
        count++;
      }
    } catch (InterruptedException e) {
      // 线程中断异常，暂时可以忽略
    }
  }

  public int get() {
    return value;
  }

}
