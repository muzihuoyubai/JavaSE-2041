import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

public class JsonUtil {

  /**
   * 将传入的字符串首字母大写
   *
   * @param str
   */
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
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

    System.out.println(JsonUtil.capitalize("asds"));
    User user = new User();
    RandomSetObjectProp.setObject(user);

    System.out.println(user);

    String json = JSONObject.toJSONString(user);
    System.out.println(json);
    System.out.println(toJsonString(user));

    String src = "{\"id\":2834,\"name\":\"d43feb55-b221-4534-914a-4c2e9efcfc30\",\"pwd\":\"8c7e708c-c018-4c9b-87ca-7a98fef8df44\",\"pwdConfirm\":\"f063b0ac-2b3d-4371-958b-013bab570aa1\",\"userType\":7244,\"userTypeStr\":\"24bf4c16-e534-42b0-a966-b769a6e3d969\"}";

    User u1 = JSONObject.parseObject(src, User.class);
    System.out.println(u1);

    User u2 = parseObject(src, User.class);
    System.out.println(u2);

  }

  /**
   * 反序列化对象
   *
   * @param str
   * @param cls
   * @param <T>
   * @return
   * @throws NoSuchMethodException
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   * @throws InstantiationException
   */
  public static <T> T parseObject(String str, Class<T> cls)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    // 获取类的无参构造方法，创建cls类的对象
    T t = cls.getDeclaredConstructor().newInstance();
    // 去字符串首尾 {}
    str = str.substring(1, str.length() - 1);
    StringTokenizer tokenizer = new StringTokenizer(str, ":|,");

    while (tokenizer.hasMoreTokens()) {
      // 获取key，再次调用，获取value
      String key = tokenizer.nextToken();
      // 用来标识有没有调用过set方法
      boolean isSet = false;
      // 取出key两边的引号
      key = key.substring(1, key.length() - 1);
      // 获取所有的方法
      Method[] declaredMethods = cls.getDeclaredMethods();
      // 依次遍历方法，搜索里面带有和key相同名字的set方法，调用这个set方法，把value传进去，完成对对象的属性的操作
      for (Method declaredMethod : declaredMethods) {
        if (declaredMethod.getName().startsWith("set")) {
          // 取出方法的set后面的名称，用来和key名字比较
          String set = declaredMethod.getName().replace("set", "");
          if (unCapitalize(set).equals(key)) {
            String value = tokenizer.nextToken();
            isSet = true;
            // 根据set方法的参数类型，将value进行类型转换
            if (declaredMethod.getParameterTypes()[0] == int.class) {
              declaredMethod.invoke(t, Integer.parseInt(value));
            } else if (declaredMethod.getParameterTypes()[0] == String.class) {
              declaredMethod.invoke(t, value.substring(1, value.length() - 1));
            }
          }
        }
      }
      // 所有的循环如果没有拿到对应key的set方法，需要再次调用，过滤掉下一次的value
      if (!isSet) {
        tokenizer.nextToken();
      }
    }

    return t;
  }

  public static String toJsonString(Object o)
      throws InvocationTargetException, IllegalAccessException {
    Method[] declaredMethods = o.getClass().getDeclaredMethods();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{");
    // 依次遍历类中的方法，调用其中的get方法，用返回的值，和get方法的名字组成key，value的json格式的字符串
    for (Method declaredMethod : declaredMethods) {
      if (declaredMethod.getName().startsWith("get")) {
        String methodName = declaredMethod.getName().replace("get", "");
        String key = unCapitalize(methodName);
        stringBuilder.append("\"").append(key).append("\"").append(":");
        Object invoke = declaredMethod.invoke(o);

        Class<?> returnType = declaredMethod.getReturnType();
        if (returnType == String.class) {
          stringBuilder.append("\"").append(invoke).append("\"");
        } else if (returnType == int.class) {
          stringBuilder.append(invoke);
        }

        stringBuilder.append(",");

      }

      // getName();
    }
    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}
