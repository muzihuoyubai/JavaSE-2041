package q13;

interface A {

  int methodA();
}

interface B {

  int methodB();
}

interface C {

  int methodC();
}

class D implements A, B, C {

  int i = 999 + 111;

  public int methodA() {
    i = +i / i;

    return i;
  }

  public int methodB() {
    i = -i * i;

    return i;
  }

  public int methodC() {
    i = ++i - --i;

    return i;
  }
}

public class MainClass {

  public static void main(String[] args) {
    D d = new D();

    System.out.println(d.i); // 1110

    System.out.println(d.methodA()); // 1

    System.out.println(d.methodB()); // -1

    System.out.println(d.methodC()); // 1
  }
}