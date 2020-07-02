package q6;

class Test {

  public static void main(String[] args) {
    try {
      int a[] = {1, 2, 3, 4};
      for (int i = 1; i <= 4; i++) {
        System.out.println("a[" + i + "]=" + a[i] + "n"); // 打印三次，第四次数组越界
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("ArrayIndexOutOfBoundsException");
    } catch (Exception e) {
      System.out.println("error = " + e);
    }
  }
}