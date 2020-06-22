package club.banyuan.animal;

public abstract class Animal {

  private int heightInCM;

  public Animal(int heightInCM) {
    setHeightInCM(heightInCM);
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    if (!isHeightValid(heightInCM)) {
      System.out.println("高度不合法:" + heightInCM);
      return;
    }
    this.heightInCM = heightInCM;
  }

  public abstract boolean isHeightValid(int heightInCM);

  // public boolean isHeightValid(int height) {
  //   return height < 100;
  // }

}
