public class StaticDemo {

  StaticDemo sd = new StaticDemo();

  void method1() {
    method4();  // 1
    StaticDemo.method2(); // 2
    StaticDemo.method3(); // 3

  }

  static void method2() {
  }

  void method3() {
    method1(); //4
    method2(); //5
    sd.method2(); //6
  }

  static void method4() {
  }
}