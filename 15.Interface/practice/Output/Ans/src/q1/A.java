package q1;

interface A {

  void myMethod();
}

class B implements A {

  public void myMethod() {
    System.out.println("My Method");
  }

  public void otherMethod() {

  }
}

class C extends B {

}

class D {

}

interface E {

}

class MainClass {

  public static void main(String[] args) {
    A a = new C();
    B b = new C();
    b.myMethod();

    a.myMethod();
    b.otherMethod();
    ((B) a).otherMethod();
    ((C) a).otherMethod();
    D a1 = (D) a;
    // D b1 = (D) b;
    E e = null;
    A d = (A) e;
  }
}