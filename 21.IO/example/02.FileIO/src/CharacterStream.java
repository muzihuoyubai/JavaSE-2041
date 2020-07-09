import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class CharacterStream {

  public static void main(String[] args) throws IOException {
    // InputStream  /  OutputStream
    // Reader / Writer
    File demo = new File("demo.txt");
    try (Writer writer = new FileWriter(demo)) {
      writer.write("你好");
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (Reader reader = new FileReader(demo)) {
      char[] buf = new char[1024];
      int read = reader.read(buf);
      StringBuilder builder = new StringBuilder();
      while (read > 0) {
        builder.append(buf, 0, read);
        // System.out.println(new String(buf, 0, read));
        read = reader.read(buf);
      }

      System.out.println(builder.toString());
    }
  }
}
