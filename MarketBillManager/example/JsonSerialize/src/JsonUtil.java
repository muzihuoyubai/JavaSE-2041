public class JsonUtil {

  /**
   * 将传入的字符串首字母大写
   *
   * @param str
   */
  public static String capitalize(String str) {
    char[] chars = str.toCharArray();
    if ('a' <= chars[0] && chars[0] <= 'z') {
      chars[0] = (char) (chars[0] - 'a' + 'A');
    }
    return new String(chars);
  }

  // public static String unCapitalize(String str) {
  //
  // }

  public static void main(String[] args) {

    System.out.println(JsonUtil.capitalize("asds"));
  }
}
