package club.banyuan.cat;

import club.banyuan.dog.Dog;

public class Cat {

  public String type;
  public String color;

  public String getInfo() {
    return color + type;
  }

  public void print() {
    System.out.println(getInfo());
  }

  public void playWith(Dog dog) {
    System.out.println(getInfo() + "和" + dog.getInfo() + "一起玩");
  }
}
