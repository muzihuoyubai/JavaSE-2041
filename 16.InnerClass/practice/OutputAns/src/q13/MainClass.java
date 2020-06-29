package q13;

class A {

  void methodA1(int i) {
    System.out.println(i++ + i);// 21 = 10+11
  }

  void methodA2(int i) {
    System.out.println(--i - i--); //9-9
  }
}

class B {

  A a = new A() {
    void methodA1(int i) {
      System.out.println(++i + i++); // 11+11
    }

    void methodA2(int i) {
      System.out.println(i-- - i); //10- 9
    }
  };
}

public class MainClass {

  public static void main(String[] args) {
    A a = new A();
    a.methodA1(10);
    a.methodA2(10);

    B b = new B();
    b.a.methodA1(10);
    b.a.methodA2(10);

    A c = b.a;
    c.methodA1(10); // 调用 匿名子类中的方法

  }
}