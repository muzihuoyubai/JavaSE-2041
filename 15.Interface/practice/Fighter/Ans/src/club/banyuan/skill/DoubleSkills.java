package club.banyuan.skill;

import club.banyuan.fighter.Fighter;
import club.banyuan.skill.Skills;

public class DoubleSkills implements Skills {

  @Override
  public void apply(Fighter from, Fighter to) {
    int hurtHp = from.getWeapon().attack() * 2;
    System.out.println(from.getName() + "使用" + from.getWeapon().getName() + "向" + to.getName() + "发起了双倍攻击");

    to.hurt(hurtHp);

  }
}
