package club.banyuan.cards;

import java.util.Arrays;
import java.util.Random;

public class Poker {

  private static final String[] patterns = {"♣", "♦", "♠", "♥"};
  private static final String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
      "Q",
      "k"};
  private static final int TOTAL_CARDS = 54;
  private Card[] cards;
  private int cardsLeft = TOTAL_CARDS;
  private static final Random random = new Random();

  public void initCards() {
    cards = new Card[TOTAL_CARDS];
    cardsLeft = TOTAL_CARDS;

    int index = 0;
    for (String pattern : patterns) {
      for (String face : faces) {
        cards[index++] = new Card(pattern, face);
      }
    }
    cards[52] = new Card("大王");
    cards[53] = new Card("小王");
  }

  public Card drawCard() {
    int drawIndex = random.nextInt(cardsLeft);
    Card rlt = cards[drawIndex];
    cards[drawIndex] = cards[cardsLeft - 1];
    cardsLeft--;
    return rlt;
  }

  public void printCards() {
    System.out.println(Arrays.toString(cards));
  }

  public void dealCard(Player player) {
    while (!player.isFull()) {
      player.receiveCard(drawCard());
    }
  }
}
