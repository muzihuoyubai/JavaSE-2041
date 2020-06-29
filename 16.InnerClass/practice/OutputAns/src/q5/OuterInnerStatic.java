package q5;

class OuterInnerStatic {

  static String s1 = "Java";
  static String s2 = "2";

  private void test() {
    // Inner.this // 语法错误
  }

  public static void main(String[] args) {
    Inner inner = new Inner();
  }

  static class Inner {

    String s1 = "Certification";
    String s2 = "Exam";

    Inner() {
      System.out.println(OuterInnerStatic.s1);
      // System.out.println(OuterInnerStatic.this.s1); // 静态内部类中不依赖外部类对象因此无法使用this指向外部类对象的引用
      System.out.println(this.s1);
      // super.super 语法错误
      // this.super 语法错误

      System.out.println(super.toString()); // 这里的super指的是Object
      System.out.println(s2);
    }
  }
}