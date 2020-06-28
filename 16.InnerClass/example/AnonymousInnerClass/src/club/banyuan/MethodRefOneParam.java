package club.banyuan;

public class MethodRefOneParam {

  private static void method(String one) {
    new MethodRefOneParam().refMethod("123");
  }

  interface OneParam {

    void method(String one);
  }

  class OneParamImpl implements OneParam {

    @Override
    public void method(String one) {
      new MethodRefOneParam().refMethod(one);
    }
  }

  interface ObjReturn {

    MethodRefOneParam method(String one);
  }

  public MethodRefOneParam() {
  }

  public MethodRefOneParam(String param) {
  }


  public void refMethod(String one) {
    System.out.println("ref");
  }

  public static void main(String[] args) {
    // 实例方法的引用
    OneParam param1 = new MethodRefOneParam()::refMethod;
    param1.method("123");
    // 静态方法的引用
    OneParam param = MethodRefOneParam::method;

    // 构造方法的引用
    ObjReturn objReturn = MethodRefOneParam::new;
  }


}
