package club.banyuan.mbm.exception;

public class FormPostException extends MbmException {

  public FormPostException() {
  }

  public FormPostException(String message) {
    super(message);
  }

  public FormPostException(String message, Throwable cause) {
    super(message, cause);
  }

  public FormPostException(Throwable cause) {
    super(cause);
  }

  public FormPostException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
