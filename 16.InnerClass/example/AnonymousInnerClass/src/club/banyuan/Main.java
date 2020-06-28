package club.banyuan;


public class Main {

  public interface OneParam {

    void method(String one);
  }

  public interface TwoParam {

    void method(String one, String two);
  }

  public static void main(String[] args) {
    Weapon weapon1 = new Weapon() {
      @Override
      public int attack() {
        return 200;
      }
    };

    Weapon weaponLambda = () -> 200;

    OneParam oneParam = new OneParam() {
      @Override
      public void method(String one) {
        System.out.println(one);
      }
    };

    OneParam oneParam1 = one -> System.out.println(one);

    TwoParam twoParam = new TwoParam() {
      @Override
      public void method(String one, String two) {
        System.out.println(one);
        System.out.println(two);
      }
    };

    TwoParam twoParam1 = (one, two) -> {
      System.out.println(one);
      System.out.println(two);
    };

    test((one, two) -> {

    });

    OneParam methodRef = new OneParam() {
      @Override
      public void method(String one) {
        System.out.println(one);
      }
    };

    OneParam methodRef1 = System.out::println;
    methodRef1.method("a");

    TwoParam methodRefTwo = new TwoParam() {
      @Override
      public void method(String one, String two) {
        one.substring(Integer.parseInt(two), 1);
      }
    };

    TwoParam methodRefTwo3 = (one, two) -> one.substring(Integer.parseInt(two), 1);

    TwoParam methodRefTwo1 = String::compareTo;

    TwoParam methodRefTwo4 = (one, two) -> Integer.parseInt(two);
  }

  static void test(TwoParam twoParam) {
    twoParam.method("a", "n");
  }


}
