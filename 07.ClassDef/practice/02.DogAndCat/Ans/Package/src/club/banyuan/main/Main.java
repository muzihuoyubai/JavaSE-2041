package club.banyuan.main;

import club.banyuan.cat.Cat;
import club.banyuan.dog.Dog;

public class Main {

  public static void main(String[] args) {
    Dog d1 = new Dog();
    d1.type = "哈士奇";
    d1.iq = -100;

    Dog d2 = new Dog();
    d2.type = "柯基";
    d2.iq = 40;

    Dog d3 = new Dog();
    d3.type = "金毛";
    d3.iq = 100;

    d1.print();
    d2.print();
    d3.print();

    Cat c1 = new Cat();
    c1.type = "波斯猫";
    c1.color = "白色";

    Cat c2 = new Cat();
    c2.type = "英短";
    c2.color = "黑色";

    c1.print();
    c2.print();

    c1.playWith(d1);
    c2.playWith(d2);
    d3.playWith(c1);
    d3.playWith(c2);
  }
}
