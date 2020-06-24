package q14;

interface A {

  String A = "AAA";

  String methodA();
}

interface B {

  String B = "BBB";

  String methodB();
}

class C implements A, B {

  public String methodA() {
    return A + B;
  }

  public String methodB() {
    return B + A;
  }
}

class D extends C implements A, B {

  String D = "DDD";

  public String methodA() {
    return D + methodB();
  }
}

public class MainClass {

  public static void main(String[] args) {
    C c = new C();

    System.out.println(c.methodA());

    System.out.println(c.methodB());

    c = new D();

    System.out.println(c.methodA());

    System.out.println(c.methodB());
  }
}