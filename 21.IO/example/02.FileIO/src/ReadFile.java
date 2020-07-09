import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

  public static void main(String[] args) {
    readFileBytesSeparate();
  }

  private static void readFileBytesSeparate() {
    File file = new File("demo.txt");
    InputStream is = null;
    byte[] buf = new byte[1024];
    List<Byte> bytes = new ArrayList<>();
    try {
      is = new FileInputStream(file);
      int count = 0;

      while ((count = is.read(buf)) > 0) {
        for (int i = 0; i < count; i++) {
          bytes.add(buf[i]);
        }
      }
      Byte[] bytes1 = bytes.toArray(new Byte[0]);
      byte[] bytes2 = new byte[bytes1.length];
      for (int i = 0; i < bytes1.length; i++) {
        bytes2[i] = bytes1[i];
      }
      System.out.println(new String(bytes2));
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static void readFile() {
    File file = new File("demo.txt");
    InputStream is = null;
    try {
      is = new FileInputStream(file);
      byte[] bytes = is.readAllBytes();
      System.out.println(new String(bytes));
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
