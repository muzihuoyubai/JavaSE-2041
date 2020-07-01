package club.banyuan.exception;

import java.lang.invoke.CallSite;

/**
 * 基本异常类，用于表示计算器内可能发生的异常。
 * <p>
 * 此类扩展了Exception，其他计算器的异常类继承此类来提供更多的错误信息
 */
public class CalculatorException extends Exception {

  public CalculatorException() {
  }

  public CalculatorException(ExceptionMsg exceptionMsg) {
    // super(exceptionMsg.getMsg());
    this(exceptionMsg.getMsg());
  }

  public CalculatorException(String message) {
    super(message);
  }

  public CalculatorException(String message, Throwable cause) {
    super(message, cause);
  }

  public CalculatorException(Throwable cause) {
    super(cause);
  }

  public CalculatorException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
