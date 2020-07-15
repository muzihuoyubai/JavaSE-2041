package club.banyuan.mbm.demo;

public class AssertDemo {

  // 运行时需要指定jvm的运行参数 -ea 开启断言检查
  public static void main(String[] args) {
    assert true;
    // assert false 将会抛出断言异常 AssertionError
    assert false;
  }
}
