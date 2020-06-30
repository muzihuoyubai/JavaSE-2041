import java.io.IOException;

public class Main {

  public static void main(String[] args) {
  }

  public static void methodB() throws IOException {
    methodA();
  }

  public static void methodC() {
    try {
      methodA();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void methodA() throws IOException {
    System.out.println("A start");
    throw new IOException("");
    // System.out.println("A end");
  }
}
