import java.lang.reflect.Field;
import java.util.UUID;

public class RandomSetObjectProp {

  public static void setObject(Object o) throws IllegalAccessException {
    Field[] declaredFields = o.getClass().getDeclaredFields();
    for (Field declaredField : declaredFields) {
      if (declaredField.getType() == String.class) {
        declaredField.setAccessible(true);
        declaredField.set(o, UUID.randomUUID().toString());
      } else if (declaredField.getType() == int.class) {
        declaredField.setAccessible(true);
        declaredField.set(o, (int) (Math.random() * 10000));
      }
    }


  }

  public static void orderMethod(Object o) {
    // Set<String> set = new TreeSet<>();
    //
    // Method[] declaredMethods = o.getClass().getDeclaredMethods();
    // for (Method declaredMethod : declaredMethods) {
    //   System.out.println(declaredMethod.getName());
    //   set.add(declaredMethod.getName());
    // }
    //
    // System.out.println(set);
  }

  public static void main(String[] args) throws IllegalAccessException {
    // User user = new User();
    // setObject(user);

    // System.out.println(user);
  }
}
