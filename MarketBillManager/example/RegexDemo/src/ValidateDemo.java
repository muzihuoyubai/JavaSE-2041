public class ValidateDemo {


  // 反射
  public static boolean validate(Object o) {
    Class<User> userClass = User.class;

    return true;
  }

  public static void main(String[] args) {
    User user = new User();
    user.setName("123456");
    user.setPwd("123456");
    boolean validate = validate(user);

    Provider provider = new Provider();
    provider.setContact("13312345678");
    provider.setName("1234");
    validate(provider);

  }
}
