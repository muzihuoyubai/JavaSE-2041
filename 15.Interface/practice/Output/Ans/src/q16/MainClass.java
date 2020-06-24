package q16;

abstract class A {

  abstract void myMethod(Number N);
}

interface B {

  abstract void myMethod(Object O);
}

class C extends A implements B {

  void myMethod(Number N) {
    System.out.println("Number");
  }

  public void myMethod(Object O) {
    System.out.println("Object");
  }
}

public class MainClass {

  public static void main(String[] args) {
    A a = new C();
    // 指定了方法参数，一定和A中定义的匹配
    a.myMethod(121);

    B b = new C();
    // 指定了方法参数，一定和B中定义的匹配
    b.myMethod(121);

    C c = new C();
    // 两个重载方法里面找最近关系的那个方法
    c.myMethod(121);
  }
}