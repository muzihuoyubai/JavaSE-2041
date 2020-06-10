public class MathOperationDemo {

  public static void main(String[] args) {
    /*
     * 算数运算符
     */
    int a = 20;
    int b = 5;
    System.out.println(a + b); // 25
    System.out.println(a - b); // 15
    System.out.println(a / b); // 4
    System.out.println(a * b); // 100
    System.out.println(a % b); // 0
    System.out.println(+a); // 20
    System.out.println(-a); // -20

    int selfOperation = 5;
    // 相当于
    // System.out.println(selfOperation);
    // selfOperation = selfOperation + 1;
    System.out.println(selfOperation++); // 5

    selfOperation = 5;
    System.out.println(selfOperation--); // 5

    selfOperation = 5;
    // 相当于
    // selfOperation = selfOperation - 1;
    // System.out.println(selfOperation);
    System.out.println(--selfOperation); // 4

    selfOperation = 5;
    System.out.println(++selfOperation); // 6

    // 浮点数算数运算存在舍入误差
    System.out.println(2.0 - 1.1); // 0.8999999999999999

    // char类型可以参与算数运算，把值作为无符号的整数看待
    System.out.println('a' + 4); // 'a'=97, + 4 =101

    /*
     * 移位运算符
     * Integer.toBinaryString 用来将int转换为二进制的字符串，方便查看结果
     * 高位的0都不输出
     */
    System.out.println(Integer.toBinaryString(0B1110_0010 & 0B1000_1100)); // 10000000
    System.out.println(Integer.toBinaryString(0B1110_0010 | 0B1000_1100)); // 11101110
    System.out.println(Integer.toBinaryString(0B1110_0010 ^ 0B1000_1100)); // 1101110
    // 注意默认是int数据类型，所以逻辑非之后高位的0都变为1
    System.out.println(Integer.toBinaryString(~0B1110_0010)); // 11111111111111111111111100011101
    System.out.println(Integer.toBinaryString(0B1110_0010 << 4)); // 111000100000
    System.out.println(Integer.toBinaryString(0B1110_0010 >> 4)); // 1110
    System.out.println(Integer.toBinaryString(0B1110_0010 >>> 4)); // 1110

  }
}
