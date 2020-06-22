package club.banyuan;

public class OrderCake extends Cake {

  private int weightInKG;

  public OrderCake(int n, double r, int weightInKG) {
    super(n, r);
    this.weightInKG = weightInKG;
  }

  public int getWeightInKG() {
    return weightInKG;
  }

  public void setWeightInKG(int weightInKG) {
    this.weightInKG = weightInKG;
  }

  @Override
  public double calcPrice() {
    return weightInKG * price;
  }
}
