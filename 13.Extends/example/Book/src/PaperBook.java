public class PaperBook extends Book {

  private double weightG;

  public PaperBook(String title, double price, double cost, int pages, double weightG) {
    super(title, price, cost, pages);
    this.weightG = weightG;
  }

  public double getWeightG() {
    return weightG;
  }

  public void setWeightG(double weightG) {
    this.weightG = weightG;
  }
}
