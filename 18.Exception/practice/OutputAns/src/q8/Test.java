package q8;

class Test {

  int count = 0;

  void A() throws Exception {
    try {
      count++;  // 1
      try {
        count++; // 2
        try {
          count++; // 3
          throw new Exception();
        } catch (Exception ex) {
          count++; // 4
          throw new Exception();
        }
        // count++; // 这里代码不会被执行
      } catch (Exception ex) {
        count++; // 5
      }
      count++; // 这里代码会被执行
    } catch (Exception ex) {
      count++;
    }
    count++; // 这里代码会被执行
  }

  void display() {
    System.out.println(count);
  }

  public static void main(String[] args) throws Exception {
    Test obj = new Test();
    obj.A();
    obj.display();
  }
}