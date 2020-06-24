package q17;

class A {

}

class B extends A {

}

class C extends B {

}

interface ABC {

  void method(A a);
}

interface PQR {

  void method(B b);
}

class M implements ABC, PQR {

  public void method(A a) {
    System.out.println(2);
  }

  public void method(B b) {
    System.out.println(3);
  }
}

public class MainClass {

  public static void main(String[] args) {
    M m = new M();

    m.method(new A());

    m.method(new B());

    m.method(new C());
  }
}