package q8;

class A {

  static String s = "AAA";

  static void methodA() {
    System.out.println(s);
  }

  static class B {

    void methodB() {
      A.methodA();
      methodA();
    }
  }
}