public class Circle {

    private double r;

    /*
     1. 添加一个构造方法传入Circle对象，新创建的对象将复制传入的Circle对象的半径。
    */

    public Circle(Circle circle) {
        r = circle.r;
    }

    public Circle(double r) {
        this.r = r;
    }

    public double calPerimeter() {
        return 2 * Math.PI * r;
    }

    public double calArea() {
        return Math.PI * r * r;
    }

    // 3.
    public void setRadius(double r) {
        this.r = r;
    }

    public double getRadius() {
        return r;
    }
}
