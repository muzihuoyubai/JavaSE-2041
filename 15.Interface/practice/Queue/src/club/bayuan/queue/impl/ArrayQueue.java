package club.bayuan.queue.impl;

import club.bayuan.queue.Queue;

public class ArrayQueue implements Queue {

  private final ArrayList arrayList = new ArrayList();

  @Override
  public void add(Object o) {
    arrayList.add(o);
  }

  @Override
  public Object delete() {
    if (isEmpty()) {
      return null;
    }
    return arrayList.remove(0);
  }

  @Override
  public boolean isEmpty() {
    return arrayList.size() == 0;
  }

}
