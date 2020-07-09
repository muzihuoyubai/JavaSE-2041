import java.io.File;
import java.io.IOException;

public class NewFile {

  public static void main(String[] args) throws IOException {
    File file = new File("");
    // File demo = new File(file.getCanonicalPath() + "/" + "demo")
    System.out.println(file.getCanonicalPath());
    File demo = new File(file.getAbsolutePath(), "demo/123/1234");
    System.out.println(demo.exists());
    System.out.println(demo.getCanonicalPath());
    // System.out.println(demo.createNewFile());
    // demo.delete();
    // demo.renameTo(new File(demo.getParent(), "1234"));

    // System.out.println(demo.mkdir());
    System.out.println(demo.mkdirs());

  }

  /**
   * 如果File是文件，删除这个File，如果是路径，则删除路径下面所有的文件，最后将这个路径删除
   *
   * @param file
   */
  void delete(File file) {
    // file.isDirectory()
    // file.listFiles()
    // file.delete()
  }
}
