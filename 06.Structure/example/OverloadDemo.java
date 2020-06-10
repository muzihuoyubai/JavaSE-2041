/**
 * 方法演示
 *
 * @author www.banyuan.club
 **/
public class OverloadDemo {

  public static void main(String[] args) {
    print(new String[]{"1", "2"});
    print("1");
    // print(null); // 编译报错，无法通过传入的值推断应该调用哪个函数
  }

  static void print(String s) {
    System.out.println("打印字符串");
    System.out.println(s);
  }

  static void print(String[] arr) {
    System.out.println("打印数组");
    for (String s : arr) {
      System.out.println(s);
    }
  }

}
