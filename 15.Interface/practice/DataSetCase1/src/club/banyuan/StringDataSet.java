package club.banyuan;

public class StringDataSet {

  private double sum;
  private int count;
  private Measurable maximum;
  private StringMeasurer stringMeasurer;
  private String maxString;

  public StringDataSet() {
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

  public void add(String s) {
    double measure = stringMeasurer.measureString(s);
    sum = sum + measure;
    if (count == 0 || stringMeasurer.measureString(maxString) < measure) {
      maxString = s;
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

  public String getMaximumStr() {
    return maxString;
  }


}