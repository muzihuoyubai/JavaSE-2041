package club.banyuan;

public class ReadyMadeCake extends Cake {

  private int quantity;

  public ReadyMadeCake(int n, double r, int quantity) {
    super(n, r);
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public double calcPrice() {
    return price * quantity;
  }
}
