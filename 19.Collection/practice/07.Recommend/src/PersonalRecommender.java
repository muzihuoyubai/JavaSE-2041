import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonalRecommender implements Recommender {

  private Map<String, List<String>> likes = new HashMap<>();
  // private List<String > list=new LinkedList<>();

  @Override
  public void add(String name, List<String> project) {
    if (name == null || project == null) {
      throw new IllegalArgumentException();
    }
    likes.put(name, project);

  }

  
  @Override
  public boolean likesBoth(String name, String project1, String project2) {
    List<String> list = likes.get(name);
    if (list == null) {
      throw new UnknownPersonException();
    }
    return list.contains(project1) && list.contains(project2);
  }

  
  @Override
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

  
  @Override
  public List<String> recommendByProject(String project) {
    Set<String> setProject = new HashSet<>();
    for (List<String> value : likes.values()) {
      if (value.contains(project)) {
        setProject.addAll(value);
      }
    }
    return new LinkedList<>(setProject);
  }

  public static void main(String[] args) {
    // List<String> list = new ArrayList<>();
    // List<String> list1 = new ArrayList<>();
    //
    // list.add("a");
    // list.add("b");
    // list.add("c");
    //
    // list1.add("2");
    // list1.add("3");
    // list1.add("4");
    //
    // list.retainAll(list1);
    //
    // System.out.println(list);
    // System.out.println(list.retainAll(list1));

    Set<Integer> set = new HashSet<>();

    List<Integer> list2 = new ArrayList<>();


    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);

    list2.addAll(set);
    System.out.println(list2);
  }
}
