public class Fridge implements SortAble {

  private int height;

  public Fridge(int height) {
    this.height = height;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public int compare(SortAble sortAble) {
    if (sortAble instanceof Fridge) {
      return this.height - ((Fridge) sortAble).height;
    }
    System.err.println("类型不匹配");
    return 0;
  }

  @Override
  public String toString() {
    return "Fridge{" +
        "height=" + height +
        '}';
  }
}
