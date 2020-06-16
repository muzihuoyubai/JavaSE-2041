public class StringBuffer {

    private String buf = "";
    private String reverse = "";

    public void append(String str) {
        for (int i = 0; i < str.length(); i++ ) {
            append(str.charAt(i));
        }
    }

    /**
     * 接收字符
     */
    public void append(char str) {
        buf += str;
        reverse = str + reverse;
    }

    /**
     * 将之前接收到的字符拼接到一起返回
     */
    public String toString() {
        return buf;
    }

    /**
     * 清除之前的而输入内容
     */
    public void clear() {
        buf = "";
        reverse = "";
    }

    /**
     * 将之前的输入内容反转
     */
    public String reverse() {
        return reverse;
    }

    /**
     * 将指定位置的字符串反转
     * from 从0起始
     * to 不包含在内
     * 即[from,to)
     * 例如 abcdefg => reverse(1,3) => acbdefg
     */
    public String reverse(int from, int to) {
        String one = buf.substring(0, from);
        String two = buf.substring(from, to);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(two);

        String three = buf.substring(to);


        return one + stringBuffer.reverse() + three;
    }

    public void shiftOne() {
        if (buf.length() == 0) {
            return;
        }
        char[] chars = buf.toCharArray();
        char one = chars[0];
        for (int i = 0; i < chars.length - 1; i++) {
            chars[i] = chars[i + 1];
        }

        chars[chars.length - 1] = one;
        buf = new String(chars);


        chars = reverse.toCharArray();
        one = chars[chars.length - 1];
        for (int i = chars.length - 1; i > 0; i--) {
            chars[i] = chars[i - 1];
        }
        chars[0] = one;
        reverse = new String(chars);

    }
}
