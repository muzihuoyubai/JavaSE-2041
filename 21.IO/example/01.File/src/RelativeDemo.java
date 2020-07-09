import java.io.File;
import java.io.IOException;

public class RelativeDemo {

  /**
   * 程序中的相对路径指的是 启动Jvm时的工作路径，
   *
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    File file = new File("./.././");
    System.out.println(file.getAbsolutePath());

    // 此方法返回的相对路径中不会包含 .. . 这种路径
    System.out.println(file.getCanonicalPath());
  }
}
