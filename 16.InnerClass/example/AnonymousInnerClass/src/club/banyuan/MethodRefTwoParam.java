package club.banyuan;

public class MethodRefTwoParam {

  private static void method(String one, String two) {
    new MethodRefTwoParam().refMethod("123", "123");
  }

  interface TwoParam {

    void method(String one, String two);
  }

  class TwoParamImpl implements TwoParam {

    @Override
    public void method(String one, String two) {
      one.contains(two);
    }
  }

  class TwoParamImpl1 implements TwoParam {

    @Override
    public void method(String one, String two) {
      new MethodRefTwoParam().refMethod(one, two);
    }
  }


  public void refMethod(String one, String two) {
    System.out.println("ref");
  }

  public void testString(String a) {
    System.out.println(a);
  }

  interface OtherTwoParam {

    void method(MethodRefTwoParam one, String two);
  }

  public static void main(String[] args) {
    // 实例方法的引用
    TwoParam param1 = new MethodRefTwoParam()::refMethod;
    param1.method("1", "2");
    // refMethod(one,two);
    TwoParam param2 = String::compareTo;
    param2.method("1", "2");
    // one.compareTo(two);
    // 静态方法的引用
    TwoParam param = MethodRefTwoParam::method;

    OtherTwoParam otherTwoParam = MethodRefTwoParam::testString;
    MethodRefTwoParam one = new MethodRefTwoParam();
    // one.testString("1");
    otherTwoParam.method(one, "1");


  }


}
