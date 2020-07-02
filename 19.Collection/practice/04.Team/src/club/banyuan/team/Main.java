package club.banyuan.team;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Team team = new Team();
    team.add(new Player("1", 1, "PG"));
    team.add(new Player("2", 2, "SG"));
    team.add(new Player("3", 3, "SF"));
    team.add(new Player("4", 4, "PF"));
    team.add(new Player("5", 5, "C"));
    team.add(new Player("6", 6, "PG"));
    team.add(new Player("7", 7, "SG"));
    team.add(new Player("8", 8, "SF"));
    team.add(new Player("9", 9, "PF"));
    team.add(new Player("10", 10, "C"));

    team.print();
    team.replace(team.getSubstitution().get(2));

    team.print();

    team.remove(team.getStarting().get(4));
    team.print();
    team.remove(team.getSubstitution().get(0));
    team.print();

    List<Player> replacePlayers = new ArrayList<>();
    replacePlayers.add(team.getStarting().get(0));
    replacePlayers.add(team.getStarting().get(2));
    // replacePlayers.add(team.getSubstitution().get(1));
    replacePlayers.add(team.getStarting().get(3));
    team.replace(replacePlayers);
    team.print();
  }
}
