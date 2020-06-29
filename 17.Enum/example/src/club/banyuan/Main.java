package club.banyuan;

import club.banyuan.cls.Animal;

public class Main {

  public static void main(String[] args) {
    System.out.println(AnimalType.TIGER.name());

    AnimalType tiger = AnimalType.valueOf("TIGER");
    System.out.println(AnimalType.TIGER);

    System.out.println(AnimalType.TIGER.ordinal());
    System.out.println(AnimalType.LION.ordinal());
    System.out.println(AnimalType.ELEPHANT.ordinal());
    System.out.println(AnimalType.ELEPHANT.compareTo(AnimalType.UNKNOWN));

    AnimalType.ELEPHANT.setName("狮子");
    System.out.println(AnimalType.ELEPHANT.getName());
  }
}
