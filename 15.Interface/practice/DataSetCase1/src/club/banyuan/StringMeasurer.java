package club.banyuan;

public class StringMeasurer implements Measurer {

  public double measureString(String s) {
    return s.length();
  }

  @Override
  public double measure(Object o) {
    return ((String) o).length();
  }

  // TODO: 创建实现Measurer接口的StringMeasurer类。提示：measure（）应该返回字符串的长度。
}
