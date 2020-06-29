package q2;

class Outer {

  public static void main(String[] args) {
    //
  }

  private class Inner {

    Inner() {
    }
    // 非静态的内部类中不允许出现static，包括修饰内部类中的内部类
    // static class InnerInner {

    // }
  }
}