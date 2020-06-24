package q3.c1;

interface A {

  int i = 111;
}

class B implements A {

  private int i = 0;

  void methodB() {
    i = A.i; // 使用接口名.变量名方式访问接口中定义的常量。
    i = 222;
  } // i是B的成员变量，覆盖了A中的i
}