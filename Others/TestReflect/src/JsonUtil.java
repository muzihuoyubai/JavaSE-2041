import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

public class JsonUtil {

  public static String serialize(Object o)
      throws InvocationTargetException, IllegalAccessException {
    Method[] declaredMethods = o.getClass().getDeclaredMethods();
    StringBuilder builder = new StringBuilder();
    builder.append("{");
    for (Method declaredMethod : declaredMethods) {
      if (declaredMethod.getName().startsWith("get")) {
        // declaredMethod.getName().replace("get")
        System.out.println(declaredMethod.getName());
        Object invoke = declaredMethod.invoke(o);
        if (invoke == null) {
          continue;
        }
        String getMethodName = declaredMethod.getName().replace("get", "");
        builder.append("\"");
        builder.append(unCapitalize(getMethodName));
        builder.append("\":");
        if (declaredMethod.getReturnType().isPrimitive()) {
          builder.append(invoke);
        } else if (declaredMethod.getReturnType() == String.class) {
          builder.append("\"").append(invoke).append("\"");
        }
        builder.append(",");
      }
    }
    if (builder.lastIndexOf(",") == builder.length() - 1) {
      builder.deleteCharAt(builder.lastIndexOf(","));
    }
    builder.append("}");
    return builder.toString();
  }

  public static <T> T deserialize(String str, Class<T> cls)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    String substring = str.substring(1, str.length() - 1);
    StringTokenizer stringTokenizer = new StringTokenizer(substring, ":|,");
    T t = cls.getDeclaredConstructor().newInstance();
    Method[] declaredMethods = cls.getDeclaredMethods();

    while (stringTokenizer.hasMoreTokens()) {
      String key = stringTokenizer.nextToken().replace("\"", "");
      key = "set" + capitalize(key);
      boolean isSet = false;
      for (Method declaredMethod : declaredMethods) {
        if (declaredMethod.getName().startsWith("set")) {
          if (declaredMethod.getName().equals(key)) {
            Class<?> parameterType = declaredMethod.getParameterTypes()[0];
            String value = stringTokenizer.nextToken();
            if (parameterType == String.class) {
              declaredMethod.invoke(t, value.replace("\"",""));
            } else if (parameterType == int.class) {
              declaredMethod.invoke(t, Integer.parseInt(value));
            }
          }
          isSet = true;
        }
      }
      if (!isSet) {
        stringTokenizer.nextToken();
      }
    }

    return t;
  }

  public static String capitalize(String str) {
    char[] chars = str.toCharArray();
    if ('a' <= chars[0] && chars[0] <= 'z') {
      chars[0] = (char) (chars[0] - 'a' + 'A');
    }
    return new String(chars);
  }

  public static String unCapitalize(String str) {
    char[] chars = str.toCharArray();
    if ('A' <= chars[0] && chars[0] <= 'Z') {
      chars[0] = (char) (chars[0] + 'a' - 'A');
    }
    return new String(chars);
  }

  public static void main(String[] args)
      throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
    User user = new User();
    user.setName("张三");
    user.setPwd("1234");
    user.setPwdConfirm("123456");
    user.setUserTypeStr("1234");
    System.out.println(JsonUtil.serialize(user));

    String str = "{\"name\":\"张三\",\"id\":0,\"pwd\":\"1234\",\"pwdConfirm\":\"123456\",\"userType\":0,\"userTypeStr\":\"1234\"}";
    User deserialize = JsonUtil.deserialize(str, User.class);
    System.out.println(deserialize);
  }


}
