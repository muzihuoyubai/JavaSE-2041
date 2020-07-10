import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedStream {

  public static void main(String[] args) throws IOException {
    long start, end;

    start = System.currentTimeMillis();
    streamRead();
    end = System.currentTimeMillis() - start;
    System.out.println("stream:" + end);

    start = System.currentTimeMillis();
    bufferedRead();
    end = System.currentTimeMillis() - start;

    System.out.println("buffered:" + end);

  }

  private static void bufferedRead() {
    try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(
        "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/doc/WIN.mp3"));
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("new.mp3"));
    ) {
      byte[] buf = new byte[1024];
      int count = 0;
      while ((count = is.read(buf)) > 0) {
        os.write(buf, 0, count);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void streamRead() {
    try (InputStream is = new FileInputStream(
        "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/doc/WIN.mp3");
        OutputStream os = new FileOutputStream("new.mp3");
    ) {
      byte[] buf = new byte[1024];
      int count = 0;
      while ((count = is.read(buf)) > 0) {
        os.write(buf, 0, count);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
