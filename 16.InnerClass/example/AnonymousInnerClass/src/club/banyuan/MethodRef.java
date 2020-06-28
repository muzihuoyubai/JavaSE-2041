package club.banyuan;

public class MethodRef {

  private static void method() {
    new MethodRef().refMethod();
  }

  interface NoParam {

    void method();
  }

  interface ObjReturn {

    MethodRef method();
  }


  private void refMethod() {
    System.out.println("ref");
  }

  public static void main(String[] args) {
    // 实例方法的引用
    NoParam param1 = new MethodRef()::refMethod;
    // 静态方法的引用
    NoParam param = MethodRef::method;

    // 构造方法的引用
    ObjReturn objReturn = MethodRef::new;
  }


}
