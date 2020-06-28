package club.banyuan.weapon.impl;

import club.banyuan.weapon.Weapon;

public class Achieve implements Weapon {

  private int hurtHP;

  public Achieve(int hurtHP) {
    this.hurtHP = hurtHP;
  }

  @Override
  public String getName() {
    return "倚天剑";
  }

  @Override
  public int attack() {
    return hurtHP;
  }
}
