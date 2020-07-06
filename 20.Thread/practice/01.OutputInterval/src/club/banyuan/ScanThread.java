package club.banyuan;

import java.util.Scanner;

public class ScanThread extends Thread {

  // 12345
  @Override
  public void run() {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String s = scanner.nextLine();
      char[] chars = s.toCharArray();
      try {
        for (char aChar : chars) {
          System.out.print(aChar);
          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    ScanThread scanThread = new ScanThread();
    scanThread.start();
  }
}
