public class PracticeAns {

  static void convert(long minute) {
    long years = minute / (60 * 24 * 365);
    int days = (int) (minute / 60 / 24) % 365;
    System.out.printf("%d分钟是%d年%d天\n", minute, years, days);
  }

  static int multiply(int n1, int n2) {
    int result = 0;
    if (n1 == 0 || n2 == 0) {
      return result;
    }
    boolean isNegative = (n1 < 0 && n2 > 0) || (n2 < 0 && n1 > 0);
    if (n1 < 0) {
      n1 = -n1;
    }

    if (n2 < 0) {
      n2 = -n2;
    }

    for (int i = 0; i < n1; i++) {
      result += n2;
    }

    if (isNegative) {
      result = -result;
    }

    return result;
  }

  public static void main(String[] args) {
    convert(3456789L);

    System.out.printf("%d*%d=%d\n", 4, 5, multiply(4, 5));
    System.out.printf("%d*%d=%d\n", -4, 5, multiply(-4, 5));
    System.out.printf("%d*%d=%d\n", -4, 0, multiply(-4, 0));
  }
}
