package club.banyuan.skill;

import club.banyuan.fighter.Fighter;

public class VertigoSkills implements Skills {

  @Override
  public void apply(Fighter from, Fighter to) {
    int hurtHp = from.getWeapon().attack() / 2;
    System.out.println(from.getName() + "使用" + from.getWeapon().getName() + "向" + to.getName() + "发起了眩晕攻击");

    to.hurt(hurtHp);
    to.vertigo(1);

  }
}
