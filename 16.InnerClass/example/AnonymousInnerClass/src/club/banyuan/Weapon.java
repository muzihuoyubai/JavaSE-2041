package club.banyuan;

public interface Weapon {

  int attack();

  default String getName() {
    return "tes";
  }


}
