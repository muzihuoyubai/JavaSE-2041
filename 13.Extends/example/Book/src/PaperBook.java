public class PaperBook {

  private String title;
  private double price;
  private double cost;
  private int pages;
  private double weightG;

  public PaperBook(String title, double price, double cost, int pages, double weightG) {
    this.title = title;
    this.price = price;
    this.cost = cost;
    this.pages = pages;
    this.weightG = weightG;
  }

  public double profit() {
    return price - cost;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public double getWeightG() {
    return weightG;
  }

  public void setWeightG(double weightG) {
    this.weightG = weightG;
  }
}
