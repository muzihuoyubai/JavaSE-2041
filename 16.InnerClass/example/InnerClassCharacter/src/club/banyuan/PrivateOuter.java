package club.banyuan;

public class PrivateOuter {

  private int outerField;

  static int staticOuterField;

  private void outerMethod() {
    new PrivateInner().getOuterObject(); // 编译通过，因为已经有外部类对象被创建了
  }

  // 私有化内部类，内部类名只能出现在外部类的内部
  private class PrivateInner {

    private int innerField;

    private void getOuterObject() {
    }
  }

  private static class StaticPrivateInner {

  }

  public static void main(String[] args) {
    PrivateInner outer = new PrivateOuter().new PrivateInner();

    StaticPrivateInner staticPrivateInner = new StaticPrivateInner();
  }
}
