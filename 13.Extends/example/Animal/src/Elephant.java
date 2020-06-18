// 子类
public class Elephant extends Animal{

  void elephantMethod() {
    System.out.println("大象的方法");
  }

  public static void main(String[] args) {
    Elephant elephant = new Elephant();
    elephant.heightInCM = 300;
    elephant.printHeight();
    elephant.elephantMethod();
  }
}
