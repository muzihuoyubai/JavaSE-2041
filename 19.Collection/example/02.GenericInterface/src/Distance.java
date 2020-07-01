public class Distance {

  private int meter;

  public Distance(int meter) {
    this.meter = meter;
  }

  public int getMeter() {
    return meter;
  }

  public void setMeter(int meter) {
    this.meter = meter;
  }

  @Override
  public String toString() {
    return "Distance{" +
        "meter=" + meter +
        '}';
  }
}
