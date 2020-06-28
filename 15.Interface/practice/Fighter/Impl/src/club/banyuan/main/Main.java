package club.banyuan.main;

import club.banyuan.fighter.Fighter;
import club.banyuan.skill.DoubleSkills;
import club.banyuan.skill.RecoverSkills;
import club.banyuan.skill.Skills;
import club.banyuan.skill.VertigoSkills;
import club.banyuan.weapon.WeaponAchieve;
import club.banyuan.weapon.WeaponKillDog;
import club.banyuan.weapon.WeaponKillDragon;

public class Main {

  public static void main(String[] args) {
    Skills[] skills = new Skills[3];
    skills[0] = new DoubleSkills();
    skills[1] = new VertigoSkills();
    skills[2] = new RecoverSkills();
    Fighter fighter1 = new Fighter("张无忌", new WeaponKillDog("打狗棒"), skills);
    // Fighter fighter2 = new Fighter("灭绝师太", new WeaponAchieve("倚天剑", 25), skills);
    Fighter fighter2 = new Fighter("灭绝师太",new WeaponKillDog("打狗棒"), skills);

    while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
      if (fighter1.getVertigo() == 0) {
        fighter1.attack(fighter2);
        if(fighter2.getHp()<=0){
          break;
        }
      } else {
        fighter1.recover();
      }
      if (fighter2.getVertigo() == 0) {
        fighter2.attack(fighter1);
      } else {
        fighter2.recover();
      }
    }
    if (fighter1.getHp()<=0) {
      System.out.println(fighter1.getName()+"被"+fighter2.getName()+"打败了");
    }else {
      System.out.println(fighter2.getName()+"被"+fighter1.getName()+"打败了");
    }

  }
}
