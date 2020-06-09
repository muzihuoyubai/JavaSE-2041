/**
 * 数据运算演示
 *
 * @author www.banyuan.club
 */
public class ConversionDemo {

  public static void main(String[] args) {

    /*
     * 数据类型转换
     */
    byte byteNum = 12;
    // 自动将byteNum的值转换成int，赋值给intNum
    int intNum = byteNum;
    // byteNum = intNum; // 编译报错，不允许这样的数据类型转换
    // char charOne = byteNum; // 编译报错, 不允许这样的数据类型转换

    intNum = 123456789;
    float floatNum = intNum;
    System.out.println(floatNum); // 1.23456792E8 只能保证最多7位精度

    // char、byte、short 变量之间的算数运算结果都是int
    short shortOne = 1;
    short shortTwo = 1;
    // 两个short运算后结果是int数据类型，不能再赋值给short
    // shortTwo = shortOne + shortTwo; // 编译报错

    // 运算赋值符号一起的时候，默认进行了强制类型转换
    // 相当于 shortTow = (short) (shortOne + shortTwo)
    shortTwo += shortOne; // 可以正常运算

    /*
     * 强制数据类型转换
     */
    // 高位截断，截断32bit以上的所有位，剩下32bit
    System.out.println(0xFFFFFFFFFFL); // 1099511627775
    System.out.println((int) 0xFFFFFFFFFFL); // -1

    double doubleOne = 9.9;
    // 小数转整数将把小数部分截断
    int intTwo = (int) doubleOne;
    System.out.println(intTwo); // 9

    /*
     * 基本数据类型和字符串使用+号连接，会转变成数值对应的字符串
     */
    // 使用 + 号，拼接字符串
    System.out.println("字符串：" + 15); // 字符串：15
    System.out.println("字符串：" + 'a'); // 字符串：a
    System.out.println("字符串：" + true); // 字符串：true
    System.out.println("字符串：" + 3.14); // 字符串：3.14

    System.out.println(3 + 4 + "字符串"); // 7字符串
    System.out.println("字符串" + 3 + 4); // 字符串34

    float floatTwo = 3.14F;
    String str = "" + floatTwo + true; // 和字符串拼接后值的数据类型是引用数据类型
    System.out.println("转字符串:" + str); // 转字符串:3.14true

  }
}
