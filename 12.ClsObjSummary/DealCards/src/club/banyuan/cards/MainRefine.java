package club.banyuan.cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 玩家1:[♦10, ♣4, ♠6, 小王, ♣9, ♣4, ♠5, ♣K, ♣6, ♣Q, ♣Q, ♣8, ♣7, ♣9, ♣2, ♦5, ♦4]
 * 玩家2:[♣3, ♣3, ♦3, 大王, ♦8, ♦6, ♦J, ♦K, ♣A, ♦2, ♠Q, ♣8, ♦Q, ♣6, ♣5, ♣10, ♠8]
 * 玩家3:[♣J, ♣5, ♠9, ♠3, ♠4, ♦A, ♠J, ♣7, ♣A, ♣2, ♦7, ♠2, ♣10, ♣J, ♠7, ♠10, ♦9]
 * 底牌:[♠K, ♣K, ♠A]
 */
public class MainRefine {

  private static int cardsLeft = 54;
  private static final Random random = new Random();
  private static final String[] cards = new String[54];
  private static final String[] patterns = {"♣", "♦", "♠", "♥"};
  private static final String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
      "Q",
      "k"};

  public static void main(String[] args) {
    int index = 0;
    for (String pattern : patterns) {
      for (String face : faces) {
        cards[index++] = pattern + face;
      }
    }
    cards[52] = "大王";
    cards[53] = "小王";

    String[] player1 = new String[17];
    String[] player2 = new String[17];
    String[] player3 = new String[17];
    String[] pool = new String[3];

    System.out.println(Arrays.toString(cards));

    dealCards(player1);
    dealCards(player2);
    dealCards(player3);
    dealCards(pool);

    System.out.println("玩家1：" + Arrays.toString(player1));
    System.out.println("玩家2：" + Arrays.toString(player2));
    System.out.println("玩家3：" + Arrays.toString(player3));
    System.out.println("底牌：" + Arrays.toString(pool));
  }

  private static void dealCards(String[] player1) {
    for (int i = 0; i < player1.length; i++) {
      int drawIndex = random.nextInt(cardsLeft); // 0~53
      player1[i] = cards[drawIndex];
      cards[drawIndex] = cards[cardsLeft - 1];
      cardsLeft--;
    }
  }

};
// 程序循环完成初始化


