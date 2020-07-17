import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    // Main qq = new Main();
    // System.out.println(qq.validateQQ("01234567"));
    // System.out.println(qq.validateQQ("12345678976"));
    // System.out.println(qq.validateQQ("124你好67"));
    // System.out.println(qq.validateQQ("1234567"));
    //
    // System.out.println(qq.validateQQRefine("01234567"));
    // System.out.println(qq.validateQQRefine("12345678976"));
    // System.out.println(qq.validateQQRefine("124你好67"));
    // System.out.println(qq.validateQQRefine("1234567"));

    stringSplit();

  }

  // 13xxxxx  15xxxx  18xxxxx
  // 7~10  首字母不能是0，必须全都是数字
  // [1-9][0-9]{6,9}
  public boolean validateQQ(String qq) {
    char[] chars = qq.toCharArray();
    int count = 0;
    if (chars.length < 7 || chars.length > 10) {
      System.out.println("错误的qq号,长度不合法，不合法的长度为：" + chars.length);
      return false;
    } else if (chars[0] > '9' || chars[0] <= '0') {
      return false;
    }
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] > '9' || chars[i] < '0') {
        return false;
      }
    }
    return true;
  }

  public boolean validateQQRefine(String qq) {
    // 正则表达式，对字符串规则的描述
    String regex = "[1-9][0-9]{6,9}";
    return qq.matches(regex);
  }

  public static void stringSplit() {
    String str = " a       b c d";
    String[] s = str.trim().split("\\s+");
    System.out.println(Arrays.toString(s));

    // \在正则表达式中也表示转义字符  例如 \? 匹配 ?， \\ 匹配 \
    String str2 = "a\\b\\c\\d\\";
    String[] split = str2.split("\\\\");
    System.out.println(Arrays.toString(split));
  }

}
