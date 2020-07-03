package club.banyuan;

public class Main {

  public static void main(String[] args) {
    Timer time = new TimerImpl();
    time.getTimeMillisecond();
    time.start();
    for (int i = 0; i < 10000000; ++i) {

    }
    time.stop();
    System.out.println(time.getTimeMillisecond());
  }

}
