public class Lion extends Animal {

  void lionMethod() {
    System.out.println("狮子的方法");
  }

  public static void main(String[] args) {
    Lion lion = new Lion();
    lion.heightInCM = 300;
    lion.printHeight();
    lion.lionMethod();
  }
}
