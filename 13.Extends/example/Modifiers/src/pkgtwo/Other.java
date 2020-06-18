package pkgtwo;

// club.banyuan.A
// club.banyuan.B

// private    default                 protected                             public
// 自己类内部   自己类内部，同包下的其他类  自己类内部，同包下的其他类，不同包下的子类   自己类内部，其他类内部都可以使用


public class Other {

  public static void main(String[] args) {
    Son son = new Son();
    // System.out.println(son.protectedField); // 编译报错
    // son.protectedMethod(); // 编译报错
  }
}
