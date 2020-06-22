package club.banyuan.animal;

public class Lion extends Animal {

  public Lion(int heightInCM) {
    super(heightInCM);
  }

  @Override
  public boolean isHeightValid(int heightInCM) {
    return heightInCM > 200;
  }
}
