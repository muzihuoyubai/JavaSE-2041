public class NewRuntimeExceptionDemo {

  public static void main(String[] args) {
    AnimalType a = AnimalType.valueOfName("123");
  }

  // static void methodA() {
  //   System.out.println("methodA start");
  //   // try {
  //   AnimalType b = AnimalType.valueOf(123);
  //   System.out.println("methodA normal");
  //   // } catch (Exception e) {
  //   //   System.out.println("捕获异常");
  //   // }
  //   System.out.println("methodA end");
  // }
  //
  // static void methodB() {
  //   System.out.println("methodB start");
  //   Object o = null;
  //   o.toString();
  //   // try {
  //   methodA();
  //   // } catch (Exception e) {
  //   //   System.out.println("捕获异常");
  //   // }
  //   System.out.println("methodB end");
  // }
}
