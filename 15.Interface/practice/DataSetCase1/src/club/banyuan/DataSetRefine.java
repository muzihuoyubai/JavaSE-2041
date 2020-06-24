package club.banyuan;

public class DataSetRefine {

  private double sum;
  private int count;
  private Object maximum;
  private Measurer measurer;

  public DataSetRefine(Measurer measurer) {
    this.measurer = measurer;
  }

  public DataSetRefine() {
    sum = 0;
    count = 0;
    maximum = null;
  }

  public void add(Measurable x) {
    double measure = x.getMeasure();
    sum = sum + measure;
    if (count == 0 || ((Measurable) maximum).getMeasure() < measure) {
      maximum = x;
    }
    count++;
  }

  public void add(Object x) {
    double measure = measurer.measure(x);
    sum = sum + measure;
    if (count == 0 || measurer.measure(maximum) < measure) {
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

  public Object getMaximum() {
    return maximum;
  }

}