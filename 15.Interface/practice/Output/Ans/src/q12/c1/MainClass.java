package q12.c1;

interface X {

  default void method() {
    System.out.println("interface X");
  }
}

class Y {

  public void method() {
    System.out.println("CLASS Y");
  }
}

class Z extends Y implements X {

  @Override
  public void method() {
    System.out.println("CLASS Z");
  }
}

public class MainClass {

  public static void main(String[] args) {
    X x = new Z();

    x.method(); // CLASS Y
  }
}