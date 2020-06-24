package q11.c1;

interface One {

  String s = "FINAL";

  String methodONE();
}

interface Two {

  String methodONE();
}

abstract class Three implements One {

  // s会屏蔽接口中的s
  String s = "NOT FINAL";

  public void test() {
    System.out.println(s);
  }

  public abstract String methodONE();
}

class Four extends Three implements One, Two {

  public String methodONE() {
    String s = super.s + One.s;
    super.s = "123";

    return s;
  }
}

public class MainClass {

  public static void main(String[] args) {
    Four four = new Four();

    System.out.println(four.methodONE()); // NOT FINALFINAL

    One one = four;

    System.out.println(one.s); // FINAL
  }
}