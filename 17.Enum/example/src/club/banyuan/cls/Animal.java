package club.banyuan.cls;

import club.banyuan.cls.AnimalType;

public class Animal {

  // public static final String LION = "狮子";
  // public static final String ELEPHANT = "大象";
  // public static final int LION = 1;
  // public static final int ELEPHANT = 2;
  // public static final String[] animalTypes = {LION, ELEPHANT};

  protected AnimalType animalType;
  // protected String animalType;

  public AnimalType getAnimalType() {
    return animalType;
  }

  public void setAnimalType(AnimalType animalType) {
    this.animalType = animalType;
  }
}
