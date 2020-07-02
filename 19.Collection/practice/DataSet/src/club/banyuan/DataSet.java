package club.banyuan;

public class DataSet<T> {

  private double sum;
  private int count;
  private T maximum;
  private Measurer<T> measurer;

  public DataSet() {
  }

  public DataSet(Measurer<T> aMeasurer) {
    sum = 0;
    count = 0;
    maximum = null;
    measurer = aMeasurer;
  }

  public void add(T x) {
    if (x instanceof Measurable) {
      add((Measurable) x);
    } else {
      addByMeasurer(x);
    }
  }

  private void addByMeasurer(T x) {
    sum = sum + measurer.measure(x);
    if (count == 0 || measurer.measure(maximum) < measurer.measure(x)) {
      maximum = x;
    }
    count++;
  }

  private void add(Measurable<T> measurable) {
    sum = sum + measurable.getMeasure();
    if (count == 0 || ((Measurable<T>) maximum).getMeasure() < measurable.getMeasure()) {
      maximum = (T)measurable;
    }
    count++;
  }

  public double getAverage() {
    if (count == 0) {
      return 0;
    }
    return sum / count;
  }

  public T getMaximum() {
    return maximum;
  }


}