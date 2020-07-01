package club.banyuan;

import java.io.Serializable;
import javax.print.attribute.standard.MediaSize.Other;

public class GenericMethod {

  public static <T> T method(T a, T b) {
    System.out.println(a.equals(b));
    return a;
  }

  public static void main(String[] args) {
    // 三者都必须是Item类型
    Item method = method(new Item(), new Item());

    // 认为两者都是Object类型，因此不会报错
    method(new Item(), new OtherItem());
  }

}
