package club.banyuan;

import java.util.Scanner;

public class ScannerDemo {

  public static void main(String[] args) {
    Scanner stringScanner = new Scanner("12345");
    System.out.println(stringScanner.hasNext()); // true
    System.out.println(stringScanner.next()); // 12345
    System.out.println(stringScanner.hasNext()); // false

    Scanner consoleScanner = new Scanner(System.in);
    int nextInt = consoleScanner.nextInt();
    System.out.println(nextInt);
    // System.out.println(consoleScanner.hasNext()); // 代码停到这里等待输入
    // System.out.println(consoleScanner.next()); // 显示输入直到下一个空格或换行符之前的字符
    // // 如果没有未处理的输入，则阻塞（上面输入abc）
    // // 如果上一个next并未返回全部的字符，则返回true(上面输入abc def)
    // System.out.println(consoleScanner.hasNext());

    String target = "12345 1234";
    Scanner strScanNextLine = new Scanner(target);
    System.out.println(strScanNextLine.hasNextLine()); // true
    System.out.println(strScanNextLine.nextLine()); // 12345 1234
    System.out.println(strScanNextLine.hasNextLine()); // false

    Scanner strScanNext = new Scanner(target);
    System.out.println(strScanNext.hasNext()); // true
    System.out.println(strScanNext.next()); // 12345
    System.out.println(strScanNext.hasNext()); // true
  }
}
