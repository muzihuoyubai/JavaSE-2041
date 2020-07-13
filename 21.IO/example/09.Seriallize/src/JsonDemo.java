import com.alibaba.fastjson.JSONObject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class JsonDemo {

  public static void main(String[] args) throws Exception {
    // String filePath = "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/example/09.Seriallize/JsonFile.json";
    Properties properties = new Properties();
    properties.load(JsonDemo.class.getClassLoader().getResourceAsStream("test.properties"));
    String filePath = properties.getProperty("abc");
    User zhangsan = new User("zhangsan", "123456");
    String s = JSONObject.toJSONString(zhangsan);

    FileOutputStream fileOutputStream = new FileOutputStream(filePath);
    fileOutputStream.write(s.getBytes());

    FileInputStream fileInputStream = new FileInputStream(filePath);
    byte[] bytes = fileInputStream.readAllBytes();
    String newStr = new String(bytes);
    User user = JSONObject.parseObject(newStr, User.class);
    System.out.println(user == zhangsan);
    System.out.println(user);
  }
}
