package q5;

class Test {

  public static void main(String[] args) {
    try {
      int a = 0;
      System.out.println("a = " + a);
      int b = 20 / a;
      System.out.println("b = " + b); // 抛出异常后，这里的代码不会被执行
    } catch (ArithmeticException e) {
      System.out.println("Divide by zero error");
    } finally {
      System.out.println("inside the finally block");
    }
  }
}