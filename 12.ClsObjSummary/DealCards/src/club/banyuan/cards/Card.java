package club.banyuan.cards;

public class Card {

  private final String pattern;
  private final String face;
  private final boolean isJoker;

  public Card(String pattern, String face) {
    this.pattern = pattern;
    this.face = face;
    this.isJoker = false;
  }

  public Card(String face) {
    this.face = face;
    this.isJoker = true;
    this.pattern = null;
  }

  @Override
  public String toString() {
    if (isJoker) {
      return face;
    }
    return pattern + face;
  }
}
