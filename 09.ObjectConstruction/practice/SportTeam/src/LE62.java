//ORIGINAL CODE

import java.util.Scanner;

public class LE62 {

  private static Scanner input = new Scanner(System.in);
  private static int size = 0;

  public static void main(String[] args) {
    String[] sport;
    String[] team;
    String[] championship;

    size = setArraySize();
    input.nextLine();

    sport = new String[size];
    team = new String[size];
    championship = new String[size];

    sport = setSportArray(sport);

    team = setTeamArray(team, sport);

    championship = setChampionshipArray(team, sport, championship);

    printArrays(sport, team, championship);

    System.exit(0);
  }//END main()

  public static int setArraySize() {
    System.out.printf("%nHow many sports are you interested in? ");
    return input.nextInt();
  }//END setArraySize()

  public static String[] setSportArray(String[] sport) {

    for (int i = 0; i < size; i++) {
      System.out.printf("%nEnter sport #%d: ", i + 1);
      sport[i] = input.nextLine();
    }

    return sport;
  }//END setSportArray

  public static String[] setTeamArray(String[] team, String[] sport) {
    for (int i = 0; i < size; i++) {
      System.out.printf("%nEnter your favorite %s team: ", sport[i]);
      team[i] = input.nextLine();
    }//END for i

    return team;
  }//END setTeamArray

  public static String[] setChampionshipArray(String[] team, String[] sport,
      String[] championship) {
    for (int k = 0; k < size; k++) {
      System.out.printf("%nEnter the year of the %s' last championship: ", team[k]);
      championship[k] = input.nextLine();
    }//END for i

    return championship;
  }

  public static void printArrays(String[] sport, String[] team, String[] championship) {
    System.out.printf("%n%nMY SPORTS TEAMS %n");

    for (int j = 0; j < size; j++) {
      System.out.printf("%nSport: %s"
          + "%nTeam: %s"
          + "%nLast Championship: %s%n", sport[j], team[j], championship[j]);
    }//END for
  }//END printArrays
}//END APP