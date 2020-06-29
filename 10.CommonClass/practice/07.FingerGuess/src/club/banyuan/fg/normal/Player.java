package club.banyuan.fg.normal;

public class Player {

  private String type;
  private int pattern;
  private boolean isOut = false;
  private String name;

  public Player(String type, String name) {
    this.type = type;
    this.name = name;
  }

  public String getName() {
    return type + name;
  }

  public void setName(String name) {
    this.name = name;
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
