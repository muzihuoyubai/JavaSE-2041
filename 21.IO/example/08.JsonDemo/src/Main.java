import com.alibaba.fastjson.JSONObject;

public class Main {

  public static void main(String[] args) {
    User user = new User("张三", "123456");

    String s = JSONObject.toJSONString(user);
    System.out.println(s);

    String str = "{\"name\":\"张三\",\"password\":\"123456\"}";
    User user1 = JSONObject.parseObject(str, User.class);
    System.out.println(user1 instanceof User);
  }
}
