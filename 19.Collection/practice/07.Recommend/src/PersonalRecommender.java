import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonalRecommender {

  private Map<String, List<String>> likes = new HashMap<>();
  // private List<String > list=new LinkedList<>();

  public void add(String name, List<String> project) {
    if (name == null || project == null) {
      throw new IllegalArgumentException();
    }
    likes.put(name, project);

  }

  public boolean likesBoth(String name, String project1, String project2) {
    List<String> list = likes.get(name);
    if (list == null) {
      throw new UnknownPersonException();
    }
    return list.contains(project1) && list.contains(project2);
  }

  public List<String> recommendByPerson(String name) {
    List<String> list = likes.get(name);
    Set<String> result = new HashSet<>();
    for (List<String> one : likes.values()) {
      List<String> list1 = new ArrayList<>(one);
      list1.retainAll(list);
      if (list1.size() > 0) {
        result.addAll(one);
      }
    }
    result.addAll(list);
    return new LinkedList<>(result);
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();

    list.add("1");
    list.add("2");
    list.add("3");

    list1.add("2");
    list1.add("3");
    list1.add("4");

    list.retainAll(list1);

    System.out.println(list);
    System.out.println(list.retainAll(list1));
  }
}
