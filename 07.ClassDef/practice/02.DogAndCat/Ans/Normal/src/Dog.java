public class Dog {

  String type;
  int iq;

  String getInfo() {
    if (iq < 20) {
      return "傻" + type;
    } else if (iq <= 80) {
      return "一般的" + type;
    } else {
      return "聪明的" + type;
    }
  }

  void print() {
    System.out.println(getInfo());
  }

  void playWith(Cat cat) {
    System.out.println(type + "和" + cat.type + "一起玩");
  }
}
