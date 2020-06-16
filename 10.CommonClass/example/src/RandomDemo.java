import java.util.Random;

public class RandomDemo {

  public static void main(String[] args) {
    int size = 1000000;
    int[] a = new int[size];
    int[] b = new int[size];
    System.arraycopy(a, 0, b, 0, size);

    for (int i = 0; i < size; i++) {
      b[i] = a[i];
    }

    Random random1 = new Random(10);
    Random random2 = new Random(10);
    System.out.println(random1.nextInt()); // -1157793070
    System.out.println(random2.nextInt()); // -1157793070
    System.out.println(random1.nextInt()); // 1913984760
    System.out.println(random2.nextInt()); // 1913984760
    System.out.println(random1.nextInt(10)); // 3
    System.out.println(random2.nextInt(10)); // 3

  }
}
