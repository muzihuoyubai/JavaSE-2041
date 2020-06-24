package club.banyuan;

public class DataSet {

  private double sum;
  private int count;
  private Measurable maximum;

  public DataSet() {
    sum = 0;
    count = 0;
    maximum = null;
  }

  public void add(Measurable x) {
    double measure = x.getMeasure();
    sum = sum + measure;
    if (count == 0 || maximum.getMeasure() < measure) {
      maximum = x;
    }
    count++;
  }

  public double getAverage() {
    if (count == 0) {
      return 0;
    }
    return sum / count;
  }

  public Measurable getMaximum() {
    return maximum;
  }


}