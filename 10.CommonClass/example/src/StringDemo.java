
public class StringDemo {

  public static void main(String[] args) {
    /**
     * 获取一个String对象
     */
    // String str = new String("newString");
    // str = "newString";
    // // 适用于所有基本数据类型
    // str = String.valueOf(123);

    String strDemo = "abcdef";
    // 求字符串长度
    System.out.printf("%s.length() = %d\n", strDemo, strDemo.length()); // 6

    // 求字符串某一位置字符
    System.out.printf("%s.charAt(2) = %c\n", strDemo, strDemo.charAt(2)); // c

    // 分割字符串，从传入的位置分割字符串
    System.out.printf("%s.subString(2) = %s\n", strDemo, strDemo.substring(2)); // cdef
    //该方法从beginIndex位置起，从当前字符串中取出到endIndex-1位置的字符作为一个新的字符串返回
    System.out.printf("%s.subString(2,4) = %s\n", strDemo, strDemo.substring(2, 4)); // cdef

    String s1 = new String("ab");
    String s2 = new String("ab");
    System.out.println(s1.equals("a"+"b"));
    System.out.println(s1 == "ab");

    System.out.println("\n======== equals ========");
    String equalsStr1 = "hello";
    String equalsStr2 = "hello";
    String equalsStr3 = "HELLO";

    System.out.println(equalsStr1.equals(equalsStr2)); // true
    System.out.println(equalsStr1.equals(equalsStr3)); // false

    System.out.println(equalsStr1.equalsIgnoreCase(equalsStr2)); // true
    System.out.println(equalsStr1.equalsIgnoreCase(equalsStr3)); // true

    System.out.println("\n======== length ========");
    String lengthStr = "hello world";
    String lengthStr2 = "你好世界";
    System.out.println(lengthStr.length()); // 11
    System.out.println(lengthStr2.length()); // 4

    System.out.println("\n======== charAt ========");
    String charAtStr = "hello world";
    System.out.println(charAtStr.charAt(0)); // h
    System.out.println(charAtStr.charAt(1)); // e

    System.out.println("\n======== substring ========");
    String subStringStr = "hello world";
    System.out.println(subStringStr.substring(4)); // o world
    System.out.println(subStringStr.substring(subStringStr.length() - 1)); // d

    System.out.println(subStringStr.substring(3, 8)); // lo wo
    System.out.println(subStringStr.substring(0, subStringStr.length() - 1)); // hello worl

    // // 字符串中单个字符查找
    // String str = "I am a good student";
    // int a = str.indexOf('a');//a = 2
    // int b = str.indexOf("good");//b = 7
    // int c = str.indexOf("w", 2);//c = -1
    // int d = str.lastIndexOf("a");//d = 5
    // int e = str.lastIndexOf("a", 3);//e = 2
    //
    // // 字符串中字符的大小写转换
    // //
    // String str = new String("asDF");
    // String str1 = str.toLowerCase();//str1 = "asdf"
    // String str2 = str.toUpperCase();//str2 = "ASDF"
    //
    // // 字符串中字符的替换
    // String str = "asdzxcasd";
    // String str1 = str.replace('a', 'g');//str1 = "gsdzxcgsd"
    // String str2 = str.replace("asd", "fgh");//str2 = "fghzxcfgh"
    // String str3 = str.replaceFirst("asd", "fgh");//str3 = "fghzxcasd"
    // String str4 = str.replaceAll("asd", "fgh");//str4 = "fghzxcfgh"
    // //
    // //
    // // trim 截去字符串两端的空格，但对于中间的空格不处理。
    // String str = " a sd ";
    // String str1 = str.trim();
    // int a = str.length();//a = 6
    // int b = str1.length();//b = 4
    //
    // // 用来比较当前字符串的起始字符或子字符串prefix和终止字符或子字符串suffix是否和当前字符串相同，重载方法中同时还可以指定比较的开始位置offset。
    //
    // String str = "asdfgh";
    // boolean a = str.statWith("as");//a = true
    // boolean b = str.endWith("gh");//b = true
    //
    // // 判断参数s是否被包含在字符串中，并返回一个布尔类型的值。
    // String str = "student";
    // str.contains("stu");//true
    // str.contains("ok");//false
    //
    // // split 将str作为分隔符进行字符串分解，分解后的字字符串在字符串数组中返回。
    // //
    // String str = "asd!qwe|zxc#";
    // String[] str1 = str.split("!|#");
    // // str1[0] = "asd";
    // // str1[1] = "qwe";
    // // str1[2] = "zxc";

  }

}
