import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCharacterStream {

  public static void main(String[] args) throws IOException {
    // InputStream  /  OutputStream
    // Reader / Writer
    File demo = new File("demo.txt");
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(demo))) {
      bufferedWriter.write("你好");
      bufferedWriter.newLine();
      bufferedWriter.write("你好！");
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(demo))) {
      String s = reader.readLine();
      StringBuilder builder = new StringBuilder();
      while (s != null) {
        builder.append(s);
        builder.append(System.lineSeparator());
        s = reader.readLine();
      }

      System.out.println(builder.toString());
    }
  }
}
