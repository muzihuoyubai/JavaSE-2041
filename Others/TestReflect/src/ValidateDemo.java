import java.lang.reflect.Field;

public class ValidateDemo {

  public static void main(String[] args) {

  }

  public void validate(Object o) {
    Field[] fields = o.getClass().getFields();
    for (int i = 0; i < fields.length; i++) {
      MyValidation declaredAnnotation = fields[i].getDeclaredAnnotation(MyValidation.class);
      if (declaredAnnotation != null) {
        System.out.println(declaredAnnotation);
      }
    }
  }

}
