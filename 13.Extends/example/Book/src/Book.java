import java.util.Objects;

public class Book {

  protected String title;
  private double price;
  private double cost;
  protected int pages;


  public Book(String title, double price, double cost, int pages) {
    this.title = title;
    this.price = price;
    this.cost = cost;
    this.pages = pages;
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

  public static void main(String[] args) {
    Book book = new Book("1", 1, 1, 1);
    Book book2 = new Book("1", 1, 1, 1);
    System.out.println(book.equals(book2));
    System.out.println(book);
  }
}
