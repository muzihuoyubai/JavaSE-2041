public enum Season {
  SPRING,
  SUMMER,
  AUTUMN,
  WINTER,
  ;


  void getMonthRange() {
    switch (this) {
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
