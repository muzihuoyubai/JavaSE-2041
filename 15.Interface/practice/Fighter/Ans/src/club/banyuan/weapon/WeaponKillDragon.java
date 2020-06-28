package club.banyuan.weapon;

import java.util.Random;

public class WeaponKillDragon implements Weapon {

  @Override
  public String getName() {
    return "屠龙刀";
  }

  @Override
  public int attack() {
    Random random =new Random();
    return random.nextInt(10)+20;
  }
}
