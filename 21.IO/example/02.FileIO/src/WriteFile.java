import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFile {

  public static void main(String[] args) {
    // File file = new File("demo.txt");
    // file.createNewFile();

    String words = "to be or not to be!";
    System.out.println(words);

    File file = new File("demo.txt");
    OutputStream os = null;
    try {
      os = new FileOutputStream(file, true);
      os.write("\n".getBytes());
      os.write(words.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (os != null) {
        try {
          os.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    // 数据 程序内存 -> 显示器、硬盘、网络   输出
    // 数据 键盘、话筒、鼠标 -> 程序内存     输入

  }
}
