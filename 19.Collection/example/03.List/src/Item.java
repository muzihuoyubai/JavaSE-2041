import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Item {

  // @Override
  // public boolean equals(Object obj) {
  //   return true;
  // }

  private int a = b++;
  private static int b;

  @Override
  public String toString() {
    return a + "";
  }

  public static void main(String[] args) {
    List<Item> list = new ArrayList<>();
    list.add(new Item());
    list.add(new Item());
    list.add(new Item());
    list.add(new Item());

    System.out.println(list.contains(new Item()));

    System.out.println(new Item().equals(new Item()));

    System.out.println(list.size());
    // list.remove(new Item());
    // System.out.println(list.size());
    System.out.println(list);
    System.out.println(list.subList(1, 2));
    System.out.println(list);
    Object[] objects = list.toArray();
    Item[] items = list.toArray(new Item[0]);

    list.sort(Comparator.comparingInt(o -> o.a));
  }
}
