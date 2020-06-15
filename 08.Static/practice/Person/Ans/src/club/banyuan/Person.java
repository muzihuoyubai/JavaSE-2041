package club.banyuan;

public class Person {

  private String name;
  private int age;
  private static int countObj = 0;
  private static int countTwoParamConstruct = 0;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    countTwoParamConstruct++;
    countObj++;
  }

  public Person(String name) {
    this.name = name;
    countObj++;
  }

  public Person() {
    countObj++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static int getCountObj() {
    return countObj;
  }

  public static int getCountTwoParamConstruct() {
    return countTwoParamConstruct;
  }
}
