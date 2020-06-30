package club.banyuan.machine;

public class FridgeGateStateIllegalException extends RuntimeException {

  public FridgeGateStateIllegalException() {
  }

  public FridgeGateStateIllegalException(String message) {
    super(message);
  }

  public FridgeGateStateIllegalException(String message, Throwable cause) {
    super(message, cause);
  }

  public FridgeGateStateIllegalException(Throwable cause) {
    super(cause);
  }

  public FridgeGateStateIllegalException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
