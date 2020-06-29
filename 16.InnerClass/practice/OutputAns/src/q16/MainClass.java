package q16;

class A {

  abstract class B {

    abstract void method();
  }

  {
    new B() {

      @Override
      void method() {
        System.out.println("BBB");
      }
    }.method();

    new B() {

      @Override
      void method() {

      }

      void method2() {

      }
    }.method2(); // 只能通过这种方式调用匿名内部类中新增的方法，如果通过父类的引用，就无法调用内部中定义的新的方法


  }
}

public class MainClass {

  public static void main(String[] args) {
    new A();
  }
}