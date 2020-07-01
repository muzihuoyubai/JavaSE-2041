package club.banyuan.exception;

import club.banyuan.exception.CalculatorException;

public class IllegalInputException extends CalculatorException {

  public IllegalInputException() {
  }

  public IllegalInputException(ExceptionMsg exceptionMsg) {
    super(exceptionMsg);
  }

  public IllegalInputException(String message) {
    super(message);
  }

  public IllegalInputException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalInputException(Throwable cause) {
    super(cause);
  }

  public IllegalInputException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
