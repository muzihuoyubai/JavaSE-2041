package club.banyuan;

public class RectangleMeasurer implements Measurer {

  @Override
  public double measure(Object o) {
    return ((Rectangle) o).getArea();
  }
}
