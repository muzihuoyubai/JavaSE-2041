package q7;

class Test {

  String str = "a"; // 1

  void A() {
    try {
      str += "b"; // 2
      B();
    } catch (Exception e) {
      str += "c"; // 6
    }
  }

  void B() throws Exception {
    try {
      str += "d"; // 3
      C();
    } catch (Exception e) {
      throw new Exception(); // (4)  抛出异常之前 5 抛出异常
    } finally {
      str += "e"; // 4
    }
    str += "f";
  }

  void C() throws Exception {
    throw new Exception();
  }

  void display() {
    System.out.println(str);
  }

  public static void main(String[] args) {
    Test object = new Test();
    object.A();
    object.display();
  }
}