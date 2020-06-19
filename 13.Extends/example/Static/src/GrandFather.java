public class GrandFather {

  static {
    System.out.println("祖父静态代码块 7"); // 7
  }

  {
    System.out.println("祖父构造代码块 8"); // 8
  }

  public void family() {
    System.out.println("祖父传下来的。。");
  }

  public static void staticMethod() {
    System.out.println("grand father static 9"); // 9
  }
}
