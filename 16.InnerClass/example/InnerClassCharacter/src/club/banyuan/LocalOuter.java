package club.banyuan;

public class LocalOuter {

  private int outerField;

  static int staticOuterField;

  private void outerMethod() {

    // 类的作用范围仅限于当前方法内部
    class LocalInner {

    }

    LocalInner localInner = new LocalInner();
  }
}
