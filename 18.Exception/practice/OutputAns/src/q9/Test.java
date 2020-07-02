package q9;

public class Test {

  public static void main(String[] args) {
    Test test = new Test();
    System.out.println(test.myMethod());
    System.out.println(test.myMethod1());
    System.out.println(test.myMethod2());
  }

  public int myMethod1() {
    int a = 1;
    try {
      return a; // 这里返回了a的值，这个值还没有经过finally的修改
    } catch (Exception e) {
      a++;
      return a;
    } finally {
      a++; // 这里对a的值进行了修改
    }
  }

  public int myMethod2() {
    int a = 1;
    try {
      return a;
    } catch (Exception e) {
      a++;
      return a;
    } finally {
      return a++; // 这里返回a的值，然后对a进行了修改
    }
  }

  public int myMethod() {

    try {
      return 1;
    } catch (Exception e) {
      return 2;
    } finally {
      return 3;
    }
  }
}
