public class SortList extends ArrayList {

  public boolean add(SortAbleElement o) {
    // 如果数组满了进行扩容
    if (count == value.length) {
      Object[] newArr = new Object[value.length * 2];
      System.arraycopy(value, 0, newArr, 0, count);
      value = newArr;
    }

    for (int i = 0; i < count; i++) {
      if (value[i] instanceof SortAbleElement) {
        if (((SortAbleElement) value[i]).compare(o) >= 0) {
          System.arraycopy(value, i, value, i + 1, count - i);
          value[i] = o;
          count++;
          return true;
        }
      }
    }

    value[count++] = o;
    return true;
  }

  public boolean add(SortAble o) {
    // 如果数组满了进行扩容
    if (count == value.length) {
      Object[] newArr = new Object[value.length * 2];
      System.arraycopy(value, 0, newArr, 0, count);
      value = newArr;
    }

    for (int i = 0; i < count; i++) {
      if (value[i] instanceof SortAble) {
        if (((SortAble) value[i]).compare(o) >= 0) {
          System.arraycopy(value, i, value, i + 1, count - i);
          value[i] = o;
          count++;
          return true;
        }
      }
    }

    value[count++] = o;
    return true;
  }


  public static void main(String[] args) {
    Elephant e1 = new Elephant(100);
    Elephant e2 = new Elephant(300);
    Elephant e3 = new Elephant(200);
    Elephant e4 = new Elephant(700);
    Elephant e5 = new Elephant(50);
    Elephant e6 = new Elephant(100);

    SortList sortList = new SortList();
    sortList.add(e1);
    sortList.add(e2);
    sortList.add(e3);
    sortList.add(e4);
    sortList.add(e5);
    sortList.add(e6);

    for (int i = 0; i < sortList.size(); i++) {
      System.out.println(sortList.get(i));
    }

    SortList sortList1 = new SortList();
    sortList1.add(new Fridge(100));
    sortList1.add(new Fridge(300));
    sortList1.add(new Fridge(100));
    sortList1.add(new Fridge(900));
    sortList1.add(new Fridge(100));
    sortList1.add(new Fridge(200));

    for (int i = 0; i < sortList1.size(); i++) {
      System.out.println(sortList1.get(i));
    }

  }
}
