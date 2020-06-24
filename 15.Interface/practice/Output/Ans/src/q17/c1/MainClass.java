package q17.c1;

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
    m.method(new A()); // 2
    m.method(new B()); // 3
    m.method(new C()); // 3

    ABC abc = m;
    abc.method(new A()); // 2
    abc.method(new B()); // 2
    abc.method(new C()); // 2

    PQR pqr = m;
    // pqr.method(new A()); // 编译报错
    pqr.method(new B()); // 3
    pqr.method(new C()); // 3
  }
}