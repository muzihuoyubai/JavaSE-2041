package club.banyuan.ans;

public class StringBuffer {

  private String buffer = "";

  /**
   * 接收字符串
   */
  public void append(String str) {
    buffer += str;
  }

  /**
   * 接收字符
   */
  public void append(char str) {
    buffer += str;
  }

  /**
   * 将之前接收到的字符拼接到一起返回
   */
  public String toString() {
    return buffer;
  }

  /**
   * 清除之前的而输入内容
   */
  public void clear() {
    buffer = "";
  }

  /**
   * 将之前的输入内容反转
   */
  public String reverse() {
    return reverseString(buffer);
  }

  private String reverseString(String str) {
    char[] chars = str.toCharArray();
    char[] reversedChars = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
      reversedChars[chars.length - 1 - i] = chars[i];
    }
    return new String(reversedChars);
  }

  /**
   * 将指定位置的字符串反转
   * from 从0起始
   * to 不包含在内
   * 即[from,to)
   * 例如 abcdefg => reverse(1,3) => acbdefg
   */
  String reverse(int from, int to) {
    if (from > to || to >= buffer.length()) {
      System.out.println("输入不合法");
      return null;
    }

    String beforeFrom = buffer.substring(0, from);
    String afterTo = buffer.substring(to);

    return beforeFrom + reverseString(buffer.substring(from, to)) + afterTo;
  }

  public static void main(String[] args) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("abc");
    stringBuffer.append('1');
    System.out.println(stringBuffer.toString());
    System.out.println(stringBuffer.reverse());
    System.out.println(stringBuffer.reverse(1, 3));
  }
}
