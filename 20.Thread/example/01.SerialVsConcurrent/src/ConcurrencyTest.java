/**
 * 这段代码的运行结果是当count值比较小的时候单线程的运行速度比多线程要快,
 * 当count的值比较大的时候多线程的计算速度远快于单线程
 * <p>
 * CPU的资源又不是全部都给这个Java程序使用的,别的程序也要占用CPU资源.
 * 比如说当我们这个程序还没有运行的时候其实可能操作系统中已经有50个线程在运行了,
 * 那么当我们这个程序运行的时候,单线程就会占用CPU51分之1的时间(假设每个线程占用时间相等)
 * 多线程就会占用CPU52分之2的时间, 因此多线程会将会占有更多的cpu的计算资源
 * cpu切换线程运行也需要花费一定的时间，这个时间如果在运算时间比较短的情况下占比就会比较大，
 * 所以当计算量比较少的时候，虽然多线程占用CPU52分之2的时间, 但是加上切换线程花费的时间可能就比单线程要慢.
 */
public class ConcurrencyTest {

  private static final long count = 1000000L;
  // private static final long count = 10000000000L;

  public static void main(String[] args) throws Exception {
    serial();
    concurrency();
  }

  private static void concurrency() throws InterruptedException {
    long start = System.currentTimeMillis();
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        int a = 0;
        for (long i = 0; i < count; i++) {
          a += 5;
        }
      }
    });
    thread.start();
    int b = 0;
    for (long i = 0; i < count; i++) {
      b--;
    }
    thread.join();
    long time = System.currentTimeMillis() - start;
    System.out.println("concurrency : " + time + "ms,b=" + b);
  }

  private static void serial() {
    long start = System.currentTimeMillis();
    int a = 0;
    for (long i = 0; i < count; i++) {
      a += 5;
    }
    int b = 0;
    for (long i = 0; i < count; i++) {
      b--;
    }
    long time = System.currentTimeMillis() - start;
    System.out.println("serial : " + time + "ms,b=" + b);
  }

}