class Sort {

  /**
   * 根据传入的参数来将数组升序或降序排列
   * 冒泡排序
   *
   * @param isAsc true 升序， false 降序
   * @param arr
   */
  static void sort(int[] arr, boolean isAsc) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (isAsc) {
          if (arr[j] > arr[j + 1]) {
            swap(arr, j, j + 1);
          }
        } else {
          if (arr[j] < arr[j + 1]) {
            swap(arr, j, j + 1);
          }
        }
      }
    }
  }

  static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  /**
   * 重载方法，将数组升序
   *
   * @param arr 目标数组
   */
  static void sort(int[] arr) {
    // 复用之前写的代码
    sort(arr, true);
  }

  /**
   * 输出数组内容
   *
   * @param arr
   */
  static void printArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("[%d]=%d ", i, arr[i]);
      if ((i + 1) % 5 == 0) {
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {13, 26, -3, 4, 54, 26, 37, 18, 69, -10};
    System.out.println("原始顺序");
    printArr(arr);
    System.out.println();
    System.out.println("降序排列");
    sort(arr, false);
    printArr(arr);
    System.out.println();
    System.out.println("升序排列");
    sort(arr);
    printArr(arr);
  }
}
