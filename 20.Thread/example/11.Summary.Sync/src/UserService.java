import java.util.ArrayList;
import java.util.List;

public class UserService {

  private List<User> userList = new ArrayList<>();

  // 加锁可以保证，在同一时间，只有一个线程在执行代码，其他线程需要排队等待这个线程释放锁。
  synchronized public void addUser(User user) {
    userList.add(user);
  }

  public void deleteUser(User user) {
    System.out.println("进入");
    // 可以对userList加锁，和上面addUser代码不是互斥的，addUser跟UserService对象要锁
    synchronized (userList) {
      userList.remove(user);
    }
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }
}
