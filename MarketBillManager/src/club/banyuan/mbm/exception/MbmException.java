package club.banyuan.mbm.exception;

public class MbmException extends RuntimeException {

  public MbmException() {
  }

  public MbmException(String message) {
    super(message);
  }

  public MbmException(String message, Throwable cause) {
    super(message, cause);
  }

  public MbmException(Throwable cause) {
    super(cause);
  }

  public MbmException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
