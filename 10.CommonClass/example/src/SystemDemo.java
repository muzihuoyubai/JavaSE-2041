public class SystemDemo {

  public static void main(String[] args) {

    // 返回当前时间距离1970年1月1日的时间差，毫秒值
    long start = System.currentTimeMillis();
    int count = 0;
    int countTo = 100000;
    for (int i = 1; i <= countTo; i++) {
      count += i;
    }
    long end = System.currentTimeMillis();
    System.out.printf("从1加到%d等于%d，一共耗时%d毫秒\n", countTo, count, end - start);

    int[] src = {1, 2, 3, 4, 5, 6, 7};
    int[] dest = {11, 22, 33};
    System.arraycopy(src, 2, dest, 0, 2); // dest[] = {3,4,33}
    for (int i = 0; i < dest.length; i++) {
      System.out.printf("[%d]=%d ", i, dest[i]);
    }
    System.out.println();

    System.exit(0);
  }
}
