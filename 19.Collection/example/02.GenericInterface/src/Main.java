import java.util.Arrays;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) {
    ComparableImpl comparable = new ComparableImpl();
    comparable.compareTo(123);
    Comparable<Integer> comparable1 = new ComparableImpl();
    comparable1.compareTo(1234);

    Comparable<Integer> comparable2 = new Comparable<Integer>() {
      @Override
      public int compareTo(Integer o) {
        return o;
      }
    };

    Comparable<Integer> comparable3 = o -> o;

    Comparator<Integer> comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    };

    Distance[] distances = new Distance[]{
        new Distance(10),
        new Distance(30),
        new Distance(20),
        new Distance(60),
        new Distance(70),
        new Distance(40)
    };
    Arrays.sort(distances, (o1, o2) -> o2.getMeter() - o1.getMeter());
    System.out.println(Arrays.toString(distances));
  }
}
