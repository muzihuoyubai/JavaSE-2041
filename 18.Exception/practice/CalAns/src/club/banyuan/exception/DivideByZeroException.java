package club.banyuan.exception;

import club.banyuan.exception.CalculatorException;

public class DivideByZeroException extends CalculatorException {

  public DivideByZeroException() {
  }

  public DivideByZeroException(String message) {
    super(message);
  }
}
