package club.banyuan;

public class StaticOuter {

  private int outerField;

  static int staticOuterField;

  private void outerMethod() {
    new StaticInner().getOuterObject(); // 编译通过，因为已经有外部类对象被创建了
  }

  // 静态内部类的行为和正常的外部类行为类似
  public static class StaticInner {

    private int innerField;

    private static int staticInnerField; // 静态内部类中允许出现static

    // 内部类可以访问外部类的实例成员和实例方法包括私有方法
    private void innerMethod() {
      // System.out.println(outerField); // 编译报错，静态的内部类，无法访问外部类的实例变量
      // outerMethod(); // 编译报错，静态的内部类，无法访问外部类的实例方法
      System.out.println(staticOuterField); // 可以访问外部类的静态成员和方法
    }

    private void getOuterObject() {
      // StaticOuter outer = StaticOuter.this; // 静态内部类中 并不会包含一个外部类对象，因此也无法使用这个方式获取外部对象
      StaticInner inner = this;
    }
  }

  public static void main(String[] args) {
    StaticOuter outer = new StaticOuter();
    outer.outerMethod();

    new StaticInner().innerMethod();

    StaticInner inner = new StaticInner();
  }
}
