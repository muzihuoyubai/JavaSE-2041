import java.io.File;

public class Main {

  public static void main(String[] args) {
    File file = new File("");
    System.out.println(file.getAbsolutePath());

    System.out.println(Main.class.getResource("/").getPath());
  }
}
