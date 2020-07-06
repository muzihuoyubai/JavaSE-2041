import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

public class CollectionTest {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();

    // Set<Entry<String, Integer>> entries = map.entrySet();
    //
    // Set<String> strings = new HashSet<>();
    // strings.add("a");
    // strings.add("b");
    // strings.add("c");
    // strings.add("d");
    // strings.add("E");
    // for (String one : strings) {
    //   System.out.println(one);
    //   strings.remove(one);
    // }

    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("E");

    // for循环添加和删除list 会出现问题
    // for (int i = 0; i < list.size(); i++) {
    //   System.out.println("remove i = " + i);
    //   list.remove(i);
    // }
    //
    // for (String s : list) {
    //   list.remove(s);
    // }
    //
    //

    // 使用迭代器的方式进行删除
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      iterator.next();
      iterator.remove(); // remove之前必须调用next，否则抛出IllegalStateException
    }

    System.out.println(list);

    Object[] oldArr = new Object[10];
    Object[] newArr = new Object[100];
    System.arraycopy(oldArr, 0, newArr, 0, 10);
    Object[] newArrByCopyOf = Arrays.copyOf(oldArr, 100);


  }
}
