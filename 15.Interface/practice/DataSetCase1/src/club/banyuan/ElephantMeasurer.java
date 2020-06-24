package club.banyuan;

public class ElephantMeasurer implements Measurer {

  @Override
  public double measure(Object o) {
    return ((Elephant) o).getHeight();
  }
}
