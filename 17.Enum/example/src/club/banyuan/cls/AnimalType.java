package club.banyuan.cls;

public class AnimalType {

  // AnimalType <=> String

  // AnimalType <=> int
  // LION <=> 1
  // ELEPHANT <=> 2
  // TIGER <=> 3

  public static final AnimalType LION = new AnimalType("狮子", 1);
  public static final AnimalType ELEPHANT = new AnimalType("大象", 2);
  public static final AnimalType TIGER = new AnimalType("老虎", 3);
  public static final AnimalType UNKNOWN = new AnimalType("未知", -1);

  private String name;
  private int code;

  private AnimalType(String name) {
    this.name = name;
  }

  private AnimalType(String name, int code) {
    this.name = name;
    this.code = code;
  }

  @Override
  public String toString() {
    return name;
  }

  public int getCode() {
    return code;
  }

  public static AnimalType valueOf(String typeName) {
    if (LION.name.equals(typeName)) {
      return LION;
    } else if (ELEPHANT.name.equals(typeName)) {
      return ELEPHANT;
    } else if (TIGER.name.equals(typeName)) {
      return TIGER;
    } else {
      return UNKNOWN;
    }
  }

  public static AnimalType valueOf(int code) {
    if (LION.code == code) {
      return LION;
    } else if (ELEPHANT.code == code) {
      return ELEPHANT;
    } else if (TIGER.code == code) {
      return TIGER;
    } else {
      return UNKNOWN;
    }
  }
}
