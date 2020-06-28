package club.banyuan.weapon;

public class WeaponKillDog implements Weapon {

  private String name;
  private int weaponAttack;


  public WeaponKillDog(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int attack() {
    return weaponAttack += 1;
  }

  public static void main(String[] args) {
    WeaponKillDog weaponKillDog = new WeaponKillDog("1");
    WeaponKillDog weaponKillDog1 = new WeaponKillDog("2");
    weaponKillDog.attack();
    weaponKillDog.attack();
    weaponKillDog.attack();
    weaponKillDog.attack();

    System.out.println(weaponKillDog1.attack());

  }
}
