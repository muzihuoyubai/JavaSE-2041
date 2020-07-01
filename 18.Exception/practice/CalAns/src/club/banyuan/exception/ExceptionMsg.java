package club.banyuan.exception;

public enum ExceptionMsg {

  ILLEGAL_ARGUMENT("Illegal Argument"),
  ILLEGAL_TOKEN_LENGTH("Illegal Token Length"),
  ILLEGAL_OPERATOR("Illegal Operator");

  String msg;

  ExceptionMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
