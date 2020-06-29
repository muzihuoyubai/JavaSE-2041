package q7;

class A {

  {
    new B();
  }
  // 可以使用static修饰，变为静态代码块
  // static {
  //   new B();
  // }

  static {
    System.out.println("A");
  }

  static class B {

    static {
      System.out.println("B");
      new A().new C();
    }
  }

  class C {

    {
      System.out.println("SUCCESS");
    }
  }
}

public class MainClass {

  public static void main(String[] args) {
    new A();
  }
}