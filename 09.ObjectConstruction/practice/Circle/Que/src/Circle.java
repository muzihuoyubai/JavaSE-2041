public class Circle {

  private double r;

  public void Circle(double r) {
    r = r;
  }

  private double calPerimeter() {
    return 2 * Math.PI * r;
  }

  public static double calArea() {
    return Math.PI * r * r;
  }
}
