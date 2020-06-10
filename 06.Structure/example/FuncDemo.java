/**
 * 方法演示
 *
 * @author www.banyuan.club
 **/
public class FuncDemo {

  public static void main(String[] args) {
    /*
     * 局部变量演示
     */
    System.out.println(getLength(new int[3])); // 3
    // System.out.println(getLength(null)); // 运行时出现空指针异常

    /*
     * 函数值的传递
     */
    int a = 5;
    int b = 10;
    System.out.println(a); // 5
    System.out.println(max(a, b)); // 10
    System.out.println(a); //  5

    int[] arr = {5, 10};
    System.out.println(arr[0]); // 5
    System.out.println(min2First(arr)); // 5
    System.out.println(arr[0]); //  10

    /*
     * 返回创建的存储区域
     */
    int[] intArr = getIntArray();
    for (int elem : intArr) {
      System.out.println(elem);
    }
  }

  /**
   * 函数变量的演示
   */
  static int getLength(int[] arr) {
    // 不允许在代码块内部定义和方法局部变量和形参同名的变量
    int intOne = 5;
    boolean flag = true;
    if (flag) {
      // int intOne = 6; // 编译报错 intOne 和外部变量同名
      // int[] arr = new int[2]; // 编译报错 arr和形参同名
    }
    return arr.length;
  }

  /**
   * a的值不会被修改，因为max中使用的是a的值，这个值保存在新的内存区域中
   * 对参数a的值修改，并不是修改main方法里面的a的内存区域的值
   */
  static int max(int a, int b) {
    if (a > b) {
      b = a;
      return a;
    } else {
      a = b;
      return b;
    }
  }

  /**
   * 对引用的变量进行修改，将会对外部产生影响
   */
  static int min2First(int[] arr) {
    if (arr[0] > arr[1]) {
      arr[1] = arr[0];
      return arr[1];
    } else {
      arr[0] = arr[1];
      return arr[0];
    }
  }

  /**
   * 可以返回使用new创建的存储区域的引用，相当于c语言返回了malloc分配的存储区域
   */
  static int[] getIntArray() {
    int[] result = new int[]{1, 2, 3, 4};
    return result;
  }
}
