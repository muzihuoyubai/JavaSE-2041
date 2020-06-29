package club.banyuan.fg.refine;

public class PlayerRefine {

  private String type;
  private int pattern;
  private boolean isOut = false;

  public PlayerRefine(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getPattern() {
    return pattern;
  }

  public void setPattern(int pattern) {
    this.pattern = pattern;
  }

  public boolean isOut() {
    return isOut;
  }

  public void setOut(boolean out) {
    isOut = out;
  }
}
