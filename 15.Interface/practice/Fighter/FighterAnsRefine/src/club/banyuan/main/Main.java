package club.banyuan.main;

import club.banyuan.fighter.Fighter;
import club.banyuan.skill.impl.DoubleAttack;
import club.banyuan.skill.impl.RecoverSkill;
import club.banyuan.skill.Skill;
import club.banyuan.skill.impl.VertigoSkill;
import club.banyuan.weapon.impl.KillDog;

public class Main {

  public static void main(String[] args) {
    // Skills[] skills = new Skills[3];
    // skills[0] = new DoubleSkills();
    // skills[1] = new VertigoSkills();
    // skills[2] = new RecoverSkills();
    Skill[] skills = new Skill[]{
        new DoubleAttack(),
        new VertigoSkill(),
        new RecoverSkill()};

    Fighter fighter1 = new Fighter("张无忌", new KillDog(), skills);
    // Fighter fighter2 = new Fighter("灭绝师太", new WeaponAchieve(25), skills);
    Fighter fighter2 = new Fighter("灭绝师太", new KillDog(), skills);

    while (fighter1.isAlive() && fighter2.isAlive()) {
      attack(fighter1, fighter2);
      if (fighter2.isAlive()) {
        attack(fighter2, fighter1);
      }
    }
    if (fighter2.isAlive()) {
      printWinner(fighter1, fighter2);
    } else {
      printWinner(fighter2, fighter1);
    }

  }

  private static void printWinner(Fighter fighter1, Fighter fighter2) {
    System.out.println(fighter1.getName() + "被" + fighter2.getName() + "打败了");
  }

  private static void attack(Fighter fighter1, Fighter fighter2) {
    if (fighter1.getVertigo() == 0) {
      fighter1.attack(fighter2);
    } else {
      fighter1.recover();
    }
  }
}
