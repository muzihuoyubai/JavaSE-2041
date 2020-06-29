package club.banyuan.fg;

import java.util.Random;
import java.util.Scanner;

// int 猜拳人数
// 1个人是玩家 n个人是计算机  =》 String 玩家类型
// n个玩家的出拳   int // 123
// n个玩家，每个玩家的胜负情况 boolean
public class Main {

  public static final String COMPUTER = "电脑";
  public static final String PLAYER = "玩家";
  public static final String STONE_WIN_PATTERN = "121";
  public static final String SCISSOR_WIN_PATTERN = "232";

  public static void main(String[] args) {

    Player[] players = initPlayers();

    while (true) {
      setPattern(players);
      compact(players);
      printrlt(players);
      players = getLeftPlayers(players);
    }
  }

  private static Player[] getLeftPlayers(Player[] players) {
    int left = 0;

    for (Player player : players) {
      if (!player.isOut()) {
        left++;
      }
    }

    Player[] playerRlt = new Player[left];
    int count = 0;
    for (Player player : players) {
      if (!player.isOut()) {
        playerRlt[count++] = player;
      }
    }
    if (playerRlt.length == 1) {
      System.exit(0);
    }
    return playerRlt;
  }

  private static void printrlt(Player[] players) {

    int left = 0;
    for (Player player : players) {
      if (!player.isOut()) {
        left++;
      }
    }

    if (players.length == left) {
      for (Player player : players) {
        System.out.println(player.getName() + "出了" + patternToString(player.getPattern()));
      }
      System.out.println("平局");
    } else {
      for (Player player : players) {
        String msg = player.isOut() ? "被淘汰" : "胜出";
        System.out.println(player.getName() + "出了" + patternToString(player.getPattern()) + msg);
      }
    }

    if (left == 1) {
      for (Player player : players) {
        if (!player.isOut()) {
          System.out.println(player.getName() + "胜出");
        }
      }
    }

  }

  private static Player[] initPlayers() {
    int usersTotal = getUsersTotal();
    Player[] players = new Player[usersTotal];
    for (int i = 1; i < players.length; i++) {
      players[i] = new Player(COMPUTER, i + "");
    }
    players[0] = new Player(PLAYER, "");
    return players;
  }

  private static void setPattern(Player[] players) {
    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      if (PLAYER.equals(player.getType())) {
        scanUserPattern(player);
      } else {
        randomPattern(player);
      }
    }
  }

  private static void compact(Player[] players) {
    String rlt = "";

    for (Player player : players) {
      if (!rlt.contains(player.getPattern() + "")) {
        rlt += player.getPattern();
      }
    }

    if (rlt.length() != 2) {
      return;
    }

    int winPattern = getWinPattern(rlt);

    for (Player player : players) {
      boolean isOut = player.getPattern() != winPattern;
      player.setOut(isOut);
    }

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
    if (STONE_WIN_PATTERN.contains(rlt)) {
      return 1;
    } else if (SCISSOR_WIN_PATTERN.contains(rlt)) {
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
