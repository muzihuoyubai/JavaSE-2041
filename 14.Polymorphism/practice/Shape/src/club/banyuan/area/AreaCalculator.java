package club.banyuan.area;

public class AreaCalculator {

  public void show(Circle circle) {
    System.out.println(circle.getShapeName() + "面积是" + String.format("%.1f", circle.area()));
    System.out.println(circle.getShapeName() + "周长是" + String.format("%.1f", circle.perimeter()));
  }
}
