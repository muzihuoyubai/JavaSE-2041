import java.util.ArrayList;
import java.util.List;

public class User {

  List<Integer> list;

  public List<Integer> getList() {
    return list;
  }

  public void setList(List<Integer> list) {
    this.list = list;
  }

  public static void main(String[] args) {
    User user = new User();
    List<Integer> list = new ArrayList<>();
    user.setList(list);
    System.out.println(user.getList());

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    System.out.println(user.getList().add(1));

    System.out.println(list);
  }
}
