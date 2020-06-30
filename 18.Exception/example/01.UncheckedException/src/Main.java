import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    // InputMismatchException
    // IllegalArgumentException
    // NullPointerException
    // IndexOfArrayOutOfBoundsException
    // ClassCastException

    Scanner scanner = new Scanner(System.in);
    try {
      int input = scanner.nextInt();
      System.out.println("执行正常");
      System.out.println(input);
    } catch (Exception e) {
      System.out.println("发生异常");
      // e.printStackTrace();
    }
    System.out.println("程序执行结束");
    //
    // String input = scanner.nextLine();
    // for (char c : input.toCharArray()) {
    //   if (c < '0' || c > '9') {
    //     System.out.println("错误");
    //   }
    // }

    // if (异常场景1) {
    //   处理方式1
    // } else if (异常场景2) {
    //   处理方式2
    // } else {
    //   正常的套路
    // }
    //
    // 执行 {
    //   正常的套路
    // }
    // {
    //   出现了什么问题？
    //   if (异常场景1) {
    //     处理方式1
    //   }
    //   if (异常场景2) {
    //     处理方式2
    //   }
    // }

    // Object o = null;
    // o.toString();

    // AnimalType.valueOf("123");

    // int[] a = new int[2];
    // System.out.println(a[3]);
  }
}
