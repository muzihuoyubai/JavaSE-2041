package club.banyuan;

public class Elephant {

  private int height;

  public Elephant(int height) {
    this.height = height;
  }

  public int getHeight() {
    return height;
  }

  // @Override
  // public double getMeasure() {
  //   return height;
  // }

  @Override
  public String toString() {
    return "Elephant{" +
        "height=" + height +
        '}';
  }

  public static void main(String[] args) {
    DataSetRefine dataSetRefine = new DataSetRefine(new ElephantMeasurer());
    dataSetRefine.add(new Elephant(123));
    dataSetRefine.add(new Elephant(234));
    dataSetRefine.add(new Elephant(345));
    System.out.println(dataSetRefine.getMaximum());
    System.out.println(dataSetRefine.getAverage());

  }
}
