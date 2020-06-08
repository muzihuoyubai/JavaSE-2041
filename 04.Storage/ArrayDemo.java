/**
 * 数组操作demo
 *
 * @author www.banyuan.club
 **/
public class ArrayDemo {

  public static void main(String[] args) {
    /*
     *  数组的声明和初始化
     */
    // 和c语言不同，并不是在声明数组的时候就分配了内存空间
    int[] arrInit;
    // 使用new 创建数组
    arrInit = new int[5];

    // 声明变量的时候创建数组并初始化
    // 等价于
    // int[] arrInit1 = new int[]{1, 2, 3, 4, 5};
    int[] arrInit1 = {1, 2, 3, 4, 5};

    // 可以先声明，然后在创建并赋值
    arrInit1 = new int[]{1, 2, 3, 4, 5};
    // 这个时候就不行了，大括号加数值只能在声明数组变量的时候使用
    // arrInit1 = {1, 2, 3, 4, 5}; // 编译报错

    /*
     * 数组的长度
     */
    int[] lengthArr = new int[3];
    // 使用length获取数组的长度。
    // length 可以看成是一个数组的成员, 是一个final int 类型
    // 随着new 创建数组后被初始化
    System.out.println(lengthArr.length); // 3

    // 可以创建出一个数组长度为0的数组
    int[] emptyArr = new int[0];
    System.out.println(emptyArr.length); // 0

    // 不允许访问不存在的数组元素，将出现异常
    int[] indexOutArr = new int[2];
    // 运行将报错 ArrayIndexOutOfBoundsException，注意是运行时报错，编译时可以通过
    // System.out.println(indexOutArr[5]);

    /*
     * 数组的初始值
     */
    System.out.println((new int[1])[0]); // 0
    System.out.println((new byte[1])[0]); // 0
    System.out.println((new short[1])[0]); // 0
    System.out.println((new char[1])[0]); // \u0000 空字符
    System.out.println((new boolean[1])[0]); // false
    System.out.println((new float[1])[0]); // 0.0
    System.out.println((new double[1])[0]); // 0.0
    System.out.println((new String[1])[0]); // null

    /*
     * 引用数据类型
     */
    // 如果不赋值，则无法使用，变量必须被初始化之后才能使用
    // int[] nullArray; // 对于下面println的时候将报错
    int[] nullArray = null;
    System.out.println(nullArray); // null
    // System.out.println(nullArray.length); // java.lang.NullPointerException

    // 数组变量的相互赋值，是赋值的引用，对其中一个内容进行修改，会被另一个数组变量获取到
    int[] refArr1 = new int[2];
    refArr1[0] = 10;
    refArr1[1] = 10;
    int[] refArr2 = refArr1;
    System.out.println(refArr1[1]); // 输出10
    refArr2[1] = 20;
    System.out.println(refArr1[1]); // 输出20

    /*
     * foreach 遍历数组
     */
    // 使用for each遍历数组
    int[] foreachArr = new int[2];
    foreachArr[0] = 1;
    foreachArr[1] = 20;
    // 依次输出foreachArr[0]和foreachArr[1]的内容
    for (int elem : foreachArr) {
      System.out.println(elem);
    }

    /*
     * 二维数组
     */
    int[][] twoDimensionalArr;
    // 二维数组的创建只需要指定一维的大小就行了，因为创建了一个引用的数组，大小是3，无论每个引用指向的内容是多大都无所谓
    twoDimensionalArr = new int[3][];
    // 二维数组的长度就是一维数组的长度
    System.out.println(twoDimensionalArr.length); // 3
    // 如果没有指定二维的大小，那么每个引用里面的内容都是null
    // System.out.println(twoDimensionalArr[0].length); // java.lang.NullPointerException

    // 可以同时指定维度
    twoDimensionalArr = new int[3][2];
    System.out.println(twoDimensionalArr.length); // 3
    // 如果指定了二维的大小，那么就会连带创建了每个二维的数组，这样引用中就不是null
    System.out.println(twoDimensionalArr[0].length); // 2
  }

}
