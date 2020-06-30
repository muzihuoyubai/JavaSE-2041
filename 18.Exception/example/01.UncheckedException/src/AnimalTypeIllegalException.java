public class AnimalTypeIllegalException extends RuntimeException {

  public AnimalTypeIllegalException() {
  }

  public AnimalTypeIllegalException(String message) {
    super(message);
  }

  public AnimalTypeIllegalException(String message, Throwable cause) {
    super(message, cause);
  }

  public AnimalTypeIllegalException(Throwable cause) {
    super(cause);
  }

  public AnimalTypeIllegalException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
