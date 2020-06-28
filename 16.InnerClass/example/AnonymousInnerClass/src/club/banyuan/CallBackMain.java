package club.banyuan;

import club.banyuan.CallbackDemo.DoSomething;

public class CallBackMain {

  public static void main(String[] args) {
    CallbackDemo callbackDemo = new CallbackDemo(() -> System.out.println("1234567"));
    callbackDemo.scanInput();

    callbackDemo = new CallbackDemo(() -> System.out.println("7654321"));

    callbackDemo.scanInput();
  }
}
