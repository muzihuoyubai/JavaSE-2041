package club.banyuan.animal;

public class Elephant extends Animal {

  public Elephant(int heightInCM) {
    super(heightInCM);
  }

  @Override
  public boolean isHeightValid(int heightInCM) {
    return heightInCM > 300;
  }


}
