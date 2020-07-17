import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyValidation {

  String sameFiledWith();

  String msg() default "数据不合法";

  String regex();

  boolean canBlank() default true;
}