package club.banyuan.mbm.uti;

import club.banyuan.mbm.entity.Validation;
import club.banyuan.mbm.exception.ValidationException;
import java.lang.reflect.Field;

public class ValidationUtil {

  public static void validate(Object o) {

    Field[] declaredFields = o.getClass().getDeclaredFields();
    for (Field declaredField : declaredFields) {

      declaredField.setAccessible(true);
      Validation annotation = declaredField.getDeclaredAnnotation(Validation.class);
      if (annotation != null) {
        String regex = annotation.regex();
        Object s;
        try {
          s = declaredField.get(o);
        } catch (IllegalAccessException e) {
          throw new ValidationException("校验失败");
        }
        if (declaredField.getType() == String.class) {
          if (!((String) s).matches(regex)) {
            throw new ValidationException(annotation.msg());
          }
        }
      }
    }
  }
}
