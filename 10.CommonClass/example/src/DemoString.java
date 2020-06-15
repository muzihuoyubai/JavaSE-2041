package club.banyuan;

public class DemoString {

  public static void main(String[] args) {
    String a = new String("a");

    System.out.println(a == "a");

    String b = new String("a");
    System.out.println(a == b);

    String c = "a";
    String d = "a";

    String ab = "ab";
    // System.out.println(c == d);
    System.out.println(ab == ("a" + "b"));
    String abc = new String("a" + "b");
  }
}
