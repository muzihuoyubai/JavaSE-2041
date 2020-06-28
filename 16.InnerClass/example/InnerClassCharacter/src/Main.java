import club.banyuan.Outer;
import club.banyuan.StaticOuter.StaticInner;
import club.banyuan.Outer.Inner;

public class Main {

  public static void main(String[] args) {
    StaticInner staticInner = new StaticInner();
    System.out.println(staticInner);

    Outer outer = new Outer();
    Inner inner = outer.new Inner();

  }
}
