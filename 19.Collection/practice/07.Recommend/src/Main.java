import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Recommender recommender = new PersonalRecommender();
    recommender.add("a", Arrays.asList("1", "2"));
  }
}
