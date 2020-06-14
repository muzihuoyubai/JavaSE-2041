package club.banyuan.dog;

import club.banyuan.cat.Cat;

public class Dog {

  public String type;
  public int iq;

  public String getInfo() {
    if (iq < 20) {
      return "傻" + type;
    } else if (iq <= 80) {
      return "一般的" + type;
    } else {
      return "聪明的" + type;
    }
  }

  public void print() {
    System.out.println(getInfo());
  }

  public void playWith(Cat cat) {
    System.out.println(type + "和" + cat.type + "一起玩");
  }
}
