package club.banyuan.machine;

import java.util.concurrent.Executors;

public class GateBrokenException extends Exception {

  public GateBrokenException() {
  }

  public GateBrokenException(String message) {
    super(message);
  }

  public GateBrokenException(String message, Throwable cause) {
    super(message, cause);
  }

  public GateBrokenException(Throwable cause) {
    super(cause);
  }

  public GateBrokenException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
