public class Cat {

  String type;
  String color;

  String getInfo() {
    return color + type;
  }

  void print() {
    System.out.println(getInfo());
  }

  void playWith(Dog dog) {
    System.out.println(getInfo() + "和" + dog.getInfo() + "一起玩");
  }
}
