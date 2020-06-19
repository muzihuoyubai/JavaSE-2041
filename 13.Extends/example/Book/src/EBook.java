public class EBook extends Book {

  private double sizeMB;

  public EBook(String title, double price, double cost, int pages, double sizeMB) {
    super(title, price, cost, pages);
    this.sizeMB = sizeMB;
  }

  public EBook(String title, double price, int pages, double sizeMB) {
    super(title, price, 0, pages);
    this.sizeMB = sizeMB;
  }

  public double getSizeMB() {
    return sizeMB;
  }

  public void setSizeMB(double sizeMB) {
    this.sizeMB = sizeMB;
  }

  public double pageSizeMB() {
    return sizeMB / pages;
  }

  public static void main(String[] args) {
    EBook eBook = new EBook("Java编程思想", 199, 0, 200, 3.5);
  }
}
