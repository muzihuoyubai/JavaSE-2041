package club.banyuan.cards;

import java.util.Arrays;
import java.util.Random;

/**
 * 玩家1:[♦10, ♣4, ♠6, 小王, ♣9, ♣4, ♠5, ♣K, ♣6, ♣Q, ♣Q, ♣8, ♣7, ♣9, ♣2, ♦5, ♦4]
 * 玩家2:[♣3, ♣3, ♦3, 大王, ♦8, ♦6, ♦J, ♦K, ♣A, ♦2, ♠Q, ♣8, ♦Q, ♣6, ♣5, ♣10, ♠8]
 * 玩家3:[♣J, ♣5, ♠9, ♠3, ♠4, ♦A, ♠J, ♣7, ♣A, ♣2, ♦7, ♠2, ♣10, ♣J, ♠7, ♠10, ♦9]
 * 底牌:[♠K, ♣K, ♠A]
 */
public class MainRefine2 {

  public static void main(String[] args) {
    Poker poker = new Poker();
    poker.initCards();
    poker.printCards();

    Player player1 = new Player("玩家1", "地主");
    Player player2 = new Player("玩家2", "农民");
    Player player3 = new Player("玩家3", "农民");

    poker.dealCard(player1);
    poker.dealCard(player2);
    poker.dealCard(player3);

    System.out.println(player1);
    System.out.println(player2);
    System.out.println(player3);
  }
};
// 程序循环完成初始化


