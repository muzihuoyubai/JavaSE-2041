package club.banyuan.skill;

import club.banyuan.fighter.Fighter;

public class RecoverSkills implements Skills {


  @Override
  public void apply(Fighter from, Fighter to) {
    int attack = from.getWeapon().attack();
    from.setHp(from.getHp() + attack);
    System.out.println(from.getName() + "恢复了" + attack + "生命值");
  }
}
