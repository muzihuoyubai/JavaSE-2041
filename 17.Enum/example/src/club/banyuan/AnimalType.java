package club.banyuan;

public class AnimalType {

  public static final AnimalType LION = new AnimalType("狮子");
  public static final AnimalType ELEPHANT = new AnimalType("大象");
  public static final AnimalType TIGER = new AnimalType("老虎");

  private String name;

  private AnimalType(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public static AnimalType valueOf(String typeName) {

    return null;
  }
}
