package obj;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    List<User> list = new LinkedList<>();
    list.add(new User("张三"));
    list.add(new User("李四"));
    list.add(new User("王五"));
    System.out.println(list);
    Set<User> set = new HashSet<>(list);
    System.out.println("set=" + set);
    for (User user : set) {
      user.setName("1");
    }
    System.out.println(list);

    list.get(0).setName("赵六");
    System.out.println(set);

    User user = list.get(1);
    user.setName("田七");
    System.out.println(set);

  }
}
