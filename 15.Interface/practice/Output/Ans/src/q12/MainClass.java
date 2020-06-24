package q12;

interface X {

  void method();
}

class Y {

  public void method() {
    System.out.println("CLASS Y");
  }
}

class Z extends Y implements X {

}

public class MainClass {

  public static void main(String[] args) {
    X x = new Z();

    x.method(); // CLASS Y
  }
}