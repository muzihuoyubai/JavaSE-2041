import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MyArrayList extends ArrayList<String> {

  @Override
  public void forEach(Consumer<? super String> action) {

    for (int i = 0; i < this.size(); i++) {
      action.accept(i + "=" + this.get(i));
    }
  }

  public static void main(String[] args) {
    List<String> list = new MyArrayList();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    list.add("6");
    list.forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    });
  }
}
