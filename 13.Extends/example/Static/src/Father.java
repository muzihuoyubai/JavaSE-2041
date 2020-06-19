public class Father extends GrandFather{

  static {
    System.out.println("父类静态代码块 3"); // 3
  }

  {
    System.out.println("父类构造代码块 4"); // 4
  }

  @Override
  public void family() {
    System.out.println("父亲传下来的。。");
  }

  public static void staticMethod() {
    System.out.println("father static 5"); // 5
  }
}
