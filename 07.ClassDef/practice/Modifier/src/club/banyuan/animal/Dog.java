
class Dog {

  String name;

  String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  void bark() {
    System.out.println(name + ": 汪汪");
  }

  void playWith(Cat cat) {
    System.out.printf("狗狗%s和猫咪%s一起玩\n", name, cat.name);
    cat.bark();
  }
}
