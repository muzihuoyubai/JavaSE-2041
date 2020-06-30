package club.banyuan.exception;

public class ElephantTooHeightException extends RuntimeException {

  public ElephantTooHeightException() {
  }

  public ElephantTooHeightException(String message) {
    super(message);
  }

  public ElephantTooHeightException(String message, Throwable cause) {
    super(message, cause);
  }

  public ElephantTooHeightException(Throwable cause) {
    super(cause);
  }

  public ElephantTooHeightException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
