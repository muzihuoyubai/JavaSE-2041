import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

  // 文件 -> 内存 -> 新文件
  // 1024 byte   -> 1024
  public static void main(String[] args) {
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
