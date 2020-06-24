package q10;

interface X {

  char c = 'A';

  char methodX();
}

class Y implements X {

  {
    System.out.println(c);
  }

  public char methodX() {
    char c = this.c;

    return ++c;
  }
}

public class MainClass {

  public static void main(String[] args) {
    Y y = new Y();  // A 构造代码块的代码会被执行

    System.out.println(y.methodX()); // B

    System.out.println(y.c); // A

    System.out.println(X.c); // A
  }
}