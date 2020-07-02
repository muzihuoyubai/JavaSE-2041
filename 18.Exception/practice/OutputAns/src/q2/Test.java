package q2;

class Test extends Exception {

}

class Main {

  public static void main(String args[]) {
    try {
      throw new Test();
    } catch (Test t) {
      System.out.println("Got the Test Exception");
      // throw new Exception(); // 抛出受查异常的语句，必须包裹在try catch中，如果没有处理，则需要方法使用throws 声明抛出异常
      throw new RuntimeException(); // 抛出异常或return，不会影响finally代码块的执行，这里面的代码始终都会执行
      // return;
    } finally {
      System.out.println("Inside finally block ");
      // return; // 如果在finally中使用return语句，则会导致抛出的异常被吃掉，尽量不要在finally中写return语句
    }
  }
}