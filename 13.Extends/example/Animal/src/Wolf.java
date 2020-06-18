public class Wolf extends Animal {
  void woldMethod() {
    printHeight();
    heightInCM = 300;
  }

  public static void main(String[] args) {
    Wolf wolf = new Wolf();
    wolf.heightInCM = 100;
    wolf.printHeight();
  }
}
