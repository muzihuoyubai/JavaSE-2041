import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class User implements Comparable<User> {

  private String name;
  private String pwd;

  public User(String name, String pwd) {
    this.name = name;
    this.pwd = pwd;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", pwd='" + pwd + '\'' +
        '}';
  }

  public static void main(String[] args) {
    List<User> userList = new ArrayList<>();
    userList.add(new User("张三", "123456"));
    userList.add(new User("张三", "1"));
    userList.add(new User("张三", "2"));
    userList.add(new User("张三", "3"));
    userList.add(new User("张三", "4"));

    Set<User> set = new HashSet<>(userList);
    System.out.println(set);
    set.add(new User("张三", "5"));
    System.out.println(set);

    // TreeSet会自动排序，需要保存的元素必须实现Comparable接口
    Set<User> treeSet = new TreeSet<>();
    treeSet.add(new User("张三", "5"));
    treeSet.add(new User("张三1", "5"));
    treeSet.add(new User("张三2", "5"));
    treeSet.add(new User("张三3", "5"));
    treeSet.add(new User("张三4", "5"));

    System.out.println(treeSet);

    Set<User> hashSet = new HashSet<>(treeSet);
    System.out.println(hashSet);

    // 保存元素的插入顺序
    Set<User> linkedSet = new LinkedHashSet<>();
    linkedSet.add(new User("张三1", "25"));
    linkedSet.add(new User("张三4", "15"));
    linkedSet.add(new User("张三", "45"));
    linkedSet.add(new User("张三3", "45"));
    linkedSet.add(new User("张三2", "55"));
    System.out.println(linkedSet);

    // 使用增强的for循环遍历
    for (User user : set) {
      System.out.println(user);
    }

    Iterator<User> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    Set<User> users = new TreeSet<>(Comparator.comparing(User::getPwd));
    System.out.println(linkedSet);
    users.addAll(linkedSet);
    System.out.println(users);

  }

  @Override
  public int compareTo(User o) {
    // return this.name.compareTo(o.name);
    return o.name.compareTo(this.name);
  }
}
