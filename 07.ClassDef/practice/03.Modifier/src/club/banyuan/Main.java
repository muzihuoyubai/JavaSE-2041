package club.banyuan;

class Main {

  static void main(String[] args) {
    Person person = new Person();
    Cat cat = new Cat();
    cat.name = "汤姆";
    Dog dog = new Dog();
    dog.setName("小强");
    person.train(dog);
    dog.playWith(cat);
  }
}


