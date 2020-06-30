public class Main {

  public static void main(String[] args) {
    // new Main().getMonthRange(Season.SPRING);
    Main.getMonthRange(Season.AUTUMN);

    Season.SPRING.getMonthRange();
  }

  static void getMonthRange(Season season) {
    switch (season) {
      case SPRING:
        System.out.println("3~5");
        break;
      case SUMMER:
        System.out.println("6~8");
        break;
      case AUTUMN:
        System.out.println("9~11");
        break;
      case WINTER:
        System.out.println("12~2");
        break;
      default:
        break;
    }
  }
}
