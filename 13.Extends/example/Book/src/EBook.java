public class EBook extends Book {

  private double sizeMB;
  // private String title;

  public EBook(String title, double price, double cost, int pages, double sizeMB) {
    super(title, price, cost, pages);
    this.title = "子类title";
    // super.title;
    this.sizeMB = sizeMB;
  }

  public EBook getThis(){
    return this;
  }

  // public Book getSuper(){
  //   return super;
  // }

  public double getSizeMB() {
    return sizeMB;
  }

  public void setSizeMB(double sizeMB) {
    this.sizeMB = sizeMB;
  }

  public void printTitle() {
    // System.out.println("子类中定义的title:" + title);
    // System.out.println("父类中定义的title:" + getTitle());
    super.getTitle();
    getTitle();
  }

  public String getTitle() {
    System.out.println("子类中定义的方法");
    return title;
  }

  public String getTitle(String a) {
    System.out.println("子类中定义的方法");
    return title;
  }

  public static void main(String[] args) {
    EBook eBook = new EBook("Java编程思想", 199, 0, 200, 3.5);
    eBook.printTitle();
    // eBook.getTitle();
  }
}
