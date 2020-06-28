package club.banyuan;

import java.util.Scanner;

public class CallbackDemo {

  public interface DoSomething {

    void doSomething();
  }

  private DoSomething callback;

  public CallbackDemo(DoSomething callback) {
    this.callback = callback;
  }

  public void scanInput() {
    Scanner scanner = new Scanner(System.in);
    if (scanner.nextLine().equals("1")) {
      callback.doSomething();
    }
  }

  public static void main(String[] args) {

    // Scanner scanner = new Scanner(System.in);

    // doSomething(new DoSomething() {
    //   @Override
    //   public void doSomething() {
    //     System.out.println("做了一些事情");
    //   }
    // });

    // while (true) {
    //   if (scanner.nextLine().equals("1")) {
    //     // System.out.println("这里做一些事情");
    //     callback.doSomething();
    //   }
    // }

  }

  // static void doSomething(DoSomething doSomething) {
  //   CallbackDemo.callback = doSomething;
  // }
}
