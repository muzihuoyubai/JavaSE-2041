import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decode {

  // /Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/02.CaesarCipher/alice.code /Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/02.CaesarCipher/alice.code.decode
  static String encodeFilePath = "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/02.CaesarCipher/alice.code";
  static String decodeFilePath = "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/02.CaesarCipher/alice.code.decode";

  public static void main(String[] args) throws IOException {
    BufferedReader inStream = null;
    BufferedWriter outStream = null;

    String inputFilePath = args[0];
    String outputFilePath = args[1];

    System.out.println("输入文件：" + inputFilePath);
    System.out.println("输出文件：" + outputFilePath);
    // TODO
    //完成此部分代码，调用 caesarDecode 对传入的inputFilePath文件进行解密
    //将解密后的文本输出到 outputFilePath 文件中
    //尝试将alice.code进行解密
    try {
      inStream = new BufferedReader(new FileReader(inputFilePath));
      outStream = new BufferedWriter(new FileWriter(outputFilePath));

      String line = inStream.readLine();
      while (line != null) {
        char[] chars = line.toCharArray();
        for (char aChar : chars) {
          outStream.write(caesarDecode(aChar));
        }
        outStream.newLine();
        line = inStream.readLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (inStream != null) {
        inStream.close();
      }

      if (outStream != null) {
        outStream.close();
      }
    }

    System.out.println("解密成功！");
  }

  public static String caesarDecode(String src) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : src.toCharArray()) {
      stringBuilder.append(caesarDecode(c));
    }
    return stringBuilder.toString();
  }

  public static char caesarDecode(char ch) {
    if (Character.isUpperCase(ch)) {
      return (char) ((ch - Encode.FIRST_UPPER + Encode.NUM_CHARS - Encode.OFFSET) % Encode.NUM_CHARS
          + Encode.FIRST_UPPER);
    } else if (Character.isLowerCase(ch)) {
      return (char) ((ch - Encode.FIRST_LOWER + Encode.NUM_CHARS - Encode.OFFSET) % Encode.NUM_CHARS
          + Encode.FIRST_LOWER);
    } else {
      return ch;
    }
  }

}

