public interface SortAble {

  /**
   * @param sortAble
   * @return > 0 表示比传入的对象大， = 0 相等， < 0 小于传入的对象
   */
  int compare(SortAble sortAble);
}
