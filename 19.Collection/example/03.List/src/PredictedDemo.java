import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredictedDemo {

  public static void main(String[] args) {
    List<Word> list = new ArrayList<>();
    list.add(new Word("123"));
    list.add(new Word("ab c"));
    list.add(new Word("1234"));
    list.add(new Word("12 3"));

    System.out.println(list);
    list.removeIf(word -> word.toString().contains(" "));

    System.out.println(list);
  }
}


class Word {

  private String s;

  public Word(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return s;
  }
}