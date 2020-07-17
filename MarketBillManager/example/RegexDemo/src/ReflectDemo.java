import java.lang.reflect.Field;

public class ReflectDemo {

  public static void main(String[] args) throws IllegalAccessException {
    User user = new User();
    user.setName("1234");
    user.setPwd("abcd");
    user.setUserType(1);

    Class<User> userClass = User.class;
    Field[] declaredFields = userClass.getDeclaredFields();
    for (Field declaredField : declaredFields) {

      declaredField.setAccessible(true);
      Validation annotation = declaredField.getDeclaredAnnotation(Validation.class);
      if (annotation != null) {
        String regex = annotation.regex();
        Object s = declaredField.get(user);
        if (declaredField.getType() == String.class) {
          System.out.println("正则匹配" + ((String) s).matches(regex));
        }
        System.out.println("validation:" + annotation);
      }

      // System.out.println(declaredField);
      // System.out.println(declaredField.get(user));
    }
  }

  // public static void main(String[] args) {
  //   String str = "1234";
  //
  //   System.out.println(str.matches("[^!@#$%^&*()]{3,10}"));
  // }
}
