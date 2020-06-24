package q6;

class A implements B {

  public int methodB(int i) {
    return i = +i * i;
  } // + 是正号
}

interface B {

  int methodB(int i);
}

public class MainClass {

  public static void main(String[] args) {
    B b = new A();

    System.out.println(b.methodB(2)); // 4
  }
}