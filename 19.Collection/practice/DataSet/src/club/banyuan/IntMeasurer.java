package club.banyuan;

public class IntMeasurer implements Measurer<Integer> {

  @Override
  public double measure(Integer anObject) {
    return anObject;
  }
}
