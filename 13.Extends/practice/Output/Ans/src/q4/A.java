package q4;

public class A {

  public A() {
    // 编译报错，调用父类的构造方法必须是构造方法的第一句语句
    // 可以放置到此处，表示调用Object的构造方法
    System.out.println(1);

    super();

    System.out.println(2);
  }
}