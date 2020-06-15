// - 添加一个构造方法传入Circle对象，新创建的对象将复制传入的Circle对象的半径。
// - 添加一个public 方法 setRadius(double r)
// - 创建一个circle2 对象，将circle1对象作为构造方法参数传入，显示其周长和半径
// - 使用setRadius 修改circle1 的半径。是否会同时修改circle2的半径？ 验证答案
// - 声明 `Circle circle3 = circle2`，当修改circle2的半径之后，circle3的周长和面积是否发生变化。
//                            - 执行上述代码后，将`circle2 = null`，circle3 的值是否为null


public class CircleApp {

    public static void main(String[] args) {
        double rd = 12.3;
        System.out.println("半径 = " + rd);

        Circle circle1 = new Circle(rd);
        double cir = circle1.calPerimeter();
        double area = circle1.calArea();

        System.out.println("周长：" + cir);
        System.out.println("面积：" + area);

        System.out.println("=================");
        // 2.
        Circle circle2 = new Circle(circle1);

        System.out.println("周长：" + circle2.calPerimeter());
        System.out.println("面积：" + circle2.calArea());
        System.out.println("半径：" + circle2.getRadius());

        System.out.println("=================");
        // 4. 不会修改半径
        circle1.setRadius(30);
        System.out.println(circle2.getRadius());


        System.out.println("=================");
        // 5. 
        Circle circle3 = circle2;
        circle2.setRadius(20);
        System.out.println("周长：" + circle3.calPerimeter());
        System.out.println("面积：" + circle3.calArea());
        System.out.println("半径：" + circle3.getRadius());

        System.out.println(circle2 == circle3);
        System.out.println(circle1 == circle3);

        // circle2 赋值，不会影响circle3 指代的内容
        circle2 = null;
        System.out.println("周长：" + circle3.calPerimeter());
        System.out.println("面积：" + circle3.calArea());
        System.out.println("半径：" + circle3.getRadius());


        // 编译通过，但是运行时候出现空指针异常
        // Circle circle3 = null;
        // circle3 = new Circle(circle3);
    }
}
