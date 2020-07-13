import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialDemo {

  public static void main(String[] args) throws Exception {
    String filePath = "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/example/09.Seriallize/ObjFile";
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(
        filePath));
    User zhangsan = new User("zhangsan", "123456");
    objectOutputStream.writeObject(zhangsan);
    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

    User o = (User) objectInputStream.readObject();
    System.out.println(o);

    System.out.println(zhangsan == o);
  }
}
