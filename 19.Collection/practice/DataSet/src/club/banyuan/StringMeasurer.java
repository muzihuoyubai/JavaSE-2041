package club.banyuan;

public class StringMeasurer implements Measurer {

  @Override
  public double measure(Object anObject) {
    if (anObject == null) {
      return 0;
    }
    if (anObject instanceof String) {
      String string = (String) anObject;
      return string.length();
    }
    throw new IllegalArgumentException("不是字符串类");
  }
}
