package club.banyuan.animal;

public class Wolf extends Animal {

  public Wolf(int heightInCM) {
    super(heightInCM);
  }

  @Override
  public boolean isHeightValid(int heightInCM) {
    return true;
  }
}
