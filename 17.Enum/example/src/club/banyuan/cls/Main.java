package club.banyuan.cls;

import club.banyuan.cls.AnimalType;
import club.banyuan.cls.Elephant;

public class Main {

  public static void main(String[] args) {
    Elephant elephant = new Elephant();
    AnimalType animalType = elephant.getAnimalType();
    System.out.println(animalType);

    // animalType = AnimalType.LION;
    //
    // if (animalType == AnimalType.ELEPHANT) {
    //   // do something
    // } else if(animalType == AnimalType.LION){
    //
    // }

    AnimalType type = AnimalType.valueOf("1");

    System.out.println(type.getCode());
    System.out.println(type);
    System.out.println(AnimalType.valueOf(1));


  }
}
