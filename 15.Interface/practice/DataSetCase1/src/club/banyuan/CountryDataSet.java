package club.banyuan;

public class CountryDataSet {

  private double sum;
  private int count;
  private CountryMeasurer measurer;
  private Country maximum;

  public CountryDataSet() {
    sum = 0;
    count = 0;
    maximum = null;
  }

  public void add(Country x) {
    double measure = measurer.measureCountry(x);
    sum = sum + measure;
    if (count == 0 || measurer.measureCountry(maximum) < measure) {
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

  public Country getMaximum() {
    return maximum;
  }


}