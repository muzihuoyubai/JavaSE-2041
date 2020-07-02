package q4;

class Base extends Exception {

}

class Derived extends Base {

}

public class Main {

  public static void main(String args[]) {
    // some other stuff
    try {
      // Some monitored code
      throw new Derived(); // 如果抛子类，可以被捕获父类异常的catch捕获到，如果抛父类，不能被捕获子类的catch捕获到
    } catch (Derived d) { // 需要保证捕获异常的catch中捕获的异常范围从小到大，从子类开始，父类放到下面
      System.out.println("Caught derived class exception");
    } catch (Base b) {
      System.out.println("Caught base class exception");
    }

  }
} 