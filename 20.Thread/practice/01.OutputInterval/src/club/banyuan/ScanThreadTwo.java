package club.banyuan;

import java.util.Scanner;

public class ScanThreadTwo extends Thread {

  public ScanThreadTwo(String name) {
    super(name);
  }

  // 12345
  @Override
  public void run() {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      System.out.println(Thread.currentThread().getName() + "going");
      String s = scanner.nextLine();
      char[] chars = s.toCharArray();
      try {
        for (char aChar : chars) {
          System.out.print(aChar);
          Thread.sleep((int)(Math.random() * 1000));
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    ScanThreadTwo scanThread = new ScanThreadTwo("线程1");
    scanThread.start();
    ScanThreadTwo scanThreadTwo = new ScanThreadTwo("线程2");
    scanThreadTwo.start();
  }
}
