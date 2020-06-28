package club.banyuan;

public class Outer {

  private int outerField;

  static int staticOuterField;

  private void outerMethod() {
    new Inner().getOuterObject(); // 编译通过，因为已经有外部类对象被创建了
  }

  public class Inner {

    private int innerField;

    // private static int staticInnerField; // 内部类中不允许出现static

    // 内部类可以访问外部类的实例成员和实例方法包括私有方法
    private void innerMethod() {
      System.out.println(outerField);
      outerMethod();
      System.out.println(staticOuterField); // 可以访问外部类的静态成员和方法
    }

    private void getOuterObject() {
      // 内部类中，使用外部类类名.this 表示外部类对象的引用。
      Outer outer = Outer.this;
      Inner inner = this;
    }
  }

  public static void main(String[] args) {
    Outer outer = new Outer();
    outer.outerMethod();

    // 创建内部类对象的时候，必须先创建外部类对象
    new Outer().new Inner().innerMethod();

    // 可以使用外部类对象创建一个内部类对象
    Inner inner = outer.new Inner();

    // new Inner(); // 编译报错，需要先创建外部类对象
  }
}
