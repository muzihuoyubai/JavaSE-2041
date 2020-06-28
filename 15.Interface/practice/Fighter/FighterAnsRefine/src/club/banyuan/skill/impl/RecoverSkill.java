package club.banyuan.skill.impl;

import club.banyuan.fighter.Fighter;
import club.banyuan.skill.Skill;

public class RecoverSkill implements Skill {


  @Override
  public void apply(Fighter from, Fighter to) {
    int attack = from.getWeapon().attack();
    from.setHp(from.getHp() + attack);
    System.out.println(from.getName() + "恢复了" + attack + "生命值");
  }
}
