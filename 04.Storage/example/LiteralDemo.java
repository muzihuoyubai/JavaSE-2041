/**
 * 数据类型的演示
 *
 * @author www.banyuan.club
 */
public class LiteralDemo {

  /*
   * 本例传入到 System.out.println 都是直接常量，也叫字面量
   * 编译器会给字面量一个默认数据类型，如果数据类型和实际意图不一致
   * 可以通过增加额外的标识来指定数据类型
   */
  public static void main(String[] args) {

    /*
     * 整数字面量
     * 以下使用不同的方式表示十进制数字255
     */
    // 十进制表示
    System.out.println(255); // 255

    // 十六进制
    System.out.println(0xFF); // 255

    // 八进制数，不建议使用此方式表示数字，不便于阅读
    System.out.println(0377); // 255

    // java7 之后 使用0b或0B开头的二进制表示
    System.out.println(0B11111111); // 255

    // 可以使用下划线分割方便阅读
    System.out.println(0B1111_1111); // 255

    /*
     * 整型字面量指定数据类型
     * 如果不指定数据类型，则默认是int数据类型，可以使用l/L来指定为long类型的字面量
     */
    // 字面量超出了整数的表示范围，编译不通过
    // System.out.println(0x1FFFFFFFF); // 编译报错
    // System.out.println(4294967295); // 编译报错
    // 表示4294967295，后面使用L或l 来标识是long类型的整数
    // 建议使用L方便阅读，因为l和1长得比较像
    System.out.println(0xFFFFFFFFL);
    System.out.println(4294967295L);

    // 0xFFFFFFFF 使用int数据类型的时候，值是-1，int的32bit，所有bit都是1，因此对于int来讲，就代表的是数字-1，
    System.out.println(0xFFFFFFFF); // -1

    // 使用long数据类型的时候，值是4294967295，因为long是64位，前面还有16个0
    System.out.println(0xFFFFFFFFL); // 4294967295

    /*
     * 小数字面量
     */
    System.out.println(3.14);
    // 使用科学计数法的方式表示小数 E或e 均可，这里表示10的-2次方
    System.out.println(314E-2); // 3.14
    System.out.println(0.0314e2); // 3.14

    /*
     * 小数字面量，指定数据类型
     * 默认小数字面量的数据类型是double
     */
    // 结尾使用D或d表示double数据类型
    System.out.println(3.14D);
    // 结尾使用F或f表示float数据类型
    System.out.println(3.14F);

    /*
     * boolean 的字面量，只有两种 true和false
     */
    System.out.println(true); // true
    System.out.println(false); // false

    /*
     * 字符字面量
     * 使用单引号括起来的字符、转义字符和Unicode表示的字符
     */
    System.out.println('c'); // c
    System.out.println('\n'); // 输出一个空行
    // unicode 字符，这里表示一个'的'汉字，u后面跟着4个十六进制字符
    // 即从 0000 ~ FFFF 共65536种组合，超出这些组合范围外的字符，例如emoji无法使用char来表示
    System.out.println('\u7684'); // 的

    /*
     * String（字符串）类型字面量
     * 使用双引号括起来
     */
    System.out.println("字符串字面量");
    // 表示一个emoji字符（码点 U+1F600），这个字符超出了char的存储范围，不能用char进行存储
    System.out.println("\uD83D\uDE00");

    /*
     * null 空引用
     */
    // 原因将在后续讲解
    // System.out.println(null); // 编译报错
  }
}
