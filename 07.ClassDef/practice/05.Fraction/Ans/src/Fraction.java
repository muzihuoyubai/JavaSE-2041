public class Fraction {

  // 分子
  int numerator;
  // 分母
  int denominator;

  double toDouble() {
    return ((double) numerator) / denominator;
  }

  Fraction plus(Fraction r) {
    Fraction fraction = new Fraction();

    fraction.numerator = numerator * r.denominator + r.numerator * denominator;
    fraction.denominator = denominator * r.denominator;
    return fraction;
  }

  Fraction multiply(Fraction r) {
    Fraction fraction = new Fraction();

    fraction.numerator = numerator * r.numerator;
    fraction.denominator = denominator * r.denominator;
    return fraction;

  }

  void print() {
    int gcd = greatestCommonDivisor(numerator, denominator);
    System.out.printf("%d / %d\n", numerator / gcd, denominator / gcd);
  }

  int greatestCommonDivisor(int a, int b) {
    int mod = a % b;
    if (mod == 0) {
      return b;
    } else {
      return greatestCommonDivisor(b, mod);
    }
  }

  public static void main(String[] args) {
    Fraction fraction = new Fraction();
    fraction.numerator = 1;
    fraction.denominator = 2;

    Fraction fraction1 = new Fraction();
    fraction1.numerator = 3;
    fraction1.denominator = 4;

    fraction.print();
    fraction1.print();

    fraction.plus(fraction1).print();
    fraction.multiply(fraction1).print();

  }

}