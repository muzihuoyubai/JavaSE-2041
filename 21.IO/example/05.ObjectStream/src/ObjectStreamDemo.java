import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {

  public static void main(String[] args) throws IOException {
    User user = new User("zhangsan", "123456");

    File file = new File(
        "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/example/05.ObjectStream", "user");

    try {
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
      objectOutputStream.writeObject(user);

    } catch (IOException e) {
      e.printStackTrace();
    }

    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

    try {
      Object o = objectInputStream.readObject();
      User u1 = (User) o;
      System.out.println(u1);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }
}
