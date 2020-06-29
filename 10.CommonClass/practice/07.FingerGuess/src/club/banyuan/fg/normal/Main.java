package club.banyuan.fg.normal;

import java.util.Random;
import java.util.Scanner;

// int 猜拳人数
// 1个人是玩家 n个人是计算机  =》 String 玩家类型
// n个玩家的出拳   int // 123
// n个玩家，每个玩家的胜负情况 boolean
public class Main {

  public static void main(String[] args) {

    int usersTotal = getUsersTotal();
    Player[] players = new Player[usersTotal];
    for (int i = 1; i < players.length; i++) {
      players[i] = new Player("电脑", i + "");
    }
    players[0] = new Player("玩家", "");
    while (true) {
      Player winner = playerWin(players);
      if (winner != null) {
        // 产生一个胜利的玩家
        System.out.println(winner.getName() + "胜出");
        break;
      }

      setPattern(players);
      compact(players);
    }


  }

  private static void setPattern(Player[] players) {
    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      if ("玩家".equals(player.getType())) {
        scanUserPattern(player);
      } else {
        randomPattern(player);
      }
    }
  }

  private static void compact(Player[] players) {
    String rlt = "";

    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      if (!rlt.contains(player.getPattern() + "")) {
        rlt += player.getPattern();
      }
    }

    if (rlt.length() != 2) {
      for (Player player : players) {
        System.out.println(player.getName() + "出了" + patternToString(player.getPattern()));
      }
      System.out.println("平局");
      return;
    }

    int winPattern = getWinPattern(rlt);

    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      boolean isOut = player.getPattern() != winPattern;
      player.setOut(isOut);
      String msg = "胜出";
      if (isOut) {
        msg = "被淘汰";
      }
      System.out.println(player.getName() + "出了" + patternToString(player.getPattern()) + msg);
    }

    // 1 石头  2 剪刀  3 布
    // 12 21  = 1
    // 23 32  = 2
    // 31 13 = 3
  }

  private static String patternToString(int pattern) {
    switch (pattern) {
      case 1:
        return "石头";
      case 2:
        return "剪刀";
      case 3:
        return "布";
    }
    return null;
  }

  private static int getWinPattern(String rlt) {
    if ("12".equals(rlt) || "21".equals(rlt)) {
      return 1;
    } else if ("23".equals(rlt) || "32".equals(rlt)) {
      return 2;
    } else {
      return 3;
    }
  }

  private static void randomPattern(Player player) {
    Random random = new Random();
    // [0,3) + 1 = [1,4) = [1,3]
    player.setPattern(random.nextInt(3) + 1);
  }

  private static void scanUserPattern(Player player) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("请出拳：\n1.石头\n2.剪刀\n3.布");
    int pattern = scanner.nextInt();
    if (pattern < 1 || pattern > 3) {
      System.out.println("输入不合法！");
      scanUserPattern(player);
    } else {
      player.setPattern(pattern);
    }
  }

  /**
   * 如果传入的数组中有多个人未被淘汰，则返回null
   * 如果只有一个人未被淘汰，则返回这个人的对象
   *
   * @param players
   * @return
   */
  private static Player playerWin(Player[] players) {
    Player winner = null;
    for (Player player : players) {
      if (winner == null && !player.isOut()) {
        winner = player;
      } else if (winner != null && !player.isOut()) {
        return null;
      }
    }
    return winner;
  }

  private static int getUsersTotal() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("多少人参与猜拳（2~5人）:");
    int rlt = scanner.nextInt();
    if (rlt > 5 || rlt < 2) {
      System.out.println("输入不合法！");
      return getUsersTotal();
    }
    return rlt;
  }
}
