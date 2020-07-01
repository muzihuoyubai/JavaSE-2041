package club.banyuan;

public class DivideByZeroException extends CalculatorException{

  public DivideByZeroException() {
  }

  public DivideByZeroException(String message) {
    super(message);
  }
}
