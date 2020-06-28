package club.banyuan.skill.impl;

import club.banyuan.fighter.Fighter;
import club.banyuan.skill.Skill;

public class VertigoSkill implements Skill {

  @Override
  public void apply(Fighter from, Fighter to) {
    int hurtHp = from.getWeapon().attack() / 2;
    System.out.println(
        from.getName() + "使用" + from.getWeapon().getName() + "向" + to.getName() + "发起了眩晕攻击");

    to.hurt(hurtHp);
    to.vertigo(1);

  }
}
