import java.io.Serializable;

public class User implements Serializable {

  String name;
  transient String password;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
