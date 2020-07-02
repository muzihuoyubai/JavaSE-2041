import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMapDemo {

  public static void main(String[] args) {
    Map<String,String> map = new MyHashMap<>();
    map.put("123","123");
    map.put("1234","123");
    map.put("1235","123");
    map.put("1236","123");

    System.out.println(map.keySet());
    System.out.println(map.values());
    System.out.println(map.get("1234"));

  }
}
