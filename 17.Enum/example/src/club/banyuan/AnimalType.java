package club.banyuan;

public enum AnimalType {
  LION("狮子", 1),
  ELEPHANT("大象", 2),
  TIGER("老虎", 3),
  UNKNOWN("未知", -1),

  ;

  private final String name;
  private final int code;

  AnimalType(String name, int code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public int getCode() {
    return code;
  }

  public static AnimalType valueOfName(String name) {
    AnimalType[] values = values();
    for (AnimalType value : values) {
      if (value.name.equals(name)) {
        return value;
      }
    }

    return UNKNOWN;
  }

  public static AnimalType valueOf(int code) {
    AnimalType[] values = values();
    for (AnimalType value : values) {
      if (value.code == code) {
        return value;
      }
    }
    return UNKNOWN;
  }
}
