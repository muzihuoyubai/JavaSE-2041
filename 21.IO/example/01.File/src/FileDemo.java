import java.io.File;

public class FileDemo {

  public static void main(String[] args) {
    // 绝对路径 相对路径
    File file = new File("/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/example/Demo.txt");
    // 查询文件的长度
    System.out.println(file.length());
    System.out.println(file.getName());
    System.out.println(file.isDirectory());
    System.out.println(file.exists());

    File directory = new File("/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO");
    System.out.println(directory.length());
    System.out.println(directory.getName());
    System.out.println(directory.isDirectory());
    System.out.println(directory.exists());

    File[] files = directory.listFiles();
    for (File one : files) {
      System.out.println(one.getName());
    }
  }
}
