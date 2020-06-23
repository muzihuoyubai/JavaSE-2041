public class Elephant extends Animal implements SortAble {

  public Elephant(int height) {
    super(height);
  }

  @Override
  public int compare(SortAble SortAble) {
    if (SortAble instanceof Elephant) {
      return this.height - ((Elephant) SortAble).height;
    }
    System.err.println("类型不匹配");
    return 0;
  }

  @Override
  public String toString() {
    return "Elephant{" +
        "height=" + height +
        '}';
  }
}
