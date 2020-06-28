package club.banyuan.weapon.impl;

import club.banyuan.weapon.Weapon;

public class KillDog implements Weapon {

  // private String name;
  private int weaponAttack;

  // public WeaponKillDog(String name) {
  //   this.name = name;
  // }

  @Override
  public String getName() {
    return "打狗棒";
  }

  @Override
  public int attack() {
    return weaponAttack += 1;
  }

  public static void main(String[] args) {
    KillDog weaponKillDog = new KillDog();
    KillDog weaponKillDog1 = new KillDog();
    weaponKillDog.attack();
    weaponKillDog.attack();
    weaponKillDog.attack();
    weaponKillDog.attack();

    // 如果 weaponAttack 是静态的，则多个对象会共享一个变量内容
    System.out.println(weaponKillDog1.attack());

  }
}
