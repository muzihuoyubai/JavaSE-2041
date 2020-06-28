package club.banyuan.weapon;

public class WeaponAchieve implements Weapon {

  private String weaponName;
  private int hurtHP;

  public WeaponAchieve(String weaponName, int hurtHP) {
    this.weaponName = weaponName;
    this.hurtHP = hurtHP;
  }

  @Override
  public String getName() {
    return weaponName;
  }

  @Override
  public int attack() {
    return hurtHP;
  }
}
