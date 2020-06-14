package club.banyuan.human;

import club.banyuan.animal.Dog;

class Person {

  void train(Dog dog) {
    System.out.println("训练狗狗" + dog.getName());
    dog.bark();
  }
}
