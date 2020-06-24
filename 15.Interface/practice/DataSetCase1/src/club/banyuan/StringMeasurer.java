package club.banyuan;

public class StringMeasurer implements Measurer {

  @Override
  public double measure(Object o) {
    return ((String) o).length();
  }
}
