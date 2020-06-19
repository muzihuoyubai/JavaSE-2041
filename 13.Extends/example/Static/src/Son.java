public class Son extends Father {

  static {
    System.out.println("子类静态代码块 1"); // 1
  }

  {
    System.out.println("子类构造代码块 2"); // 2
  }

  public static void staticMethod() {
    System.out.println("son static 6"); // 6
  }

  @Override
  public void family() {
    super.family();
  }

  public static void main(String[] args) {
    Son.staticMethod();
    Son son = new Son();
    son.family();
  }
}
