package q11;

class A {

  void methodOne() {
    class B {

      void methodTwo() {
        System.out.println("Method Two");
      }
    }
    new B().methodTwo();
  }

  // void methodThree() {
  //   new A().new B().methodTwo(); // 超出了局部内部类的作用范围
  // }
}