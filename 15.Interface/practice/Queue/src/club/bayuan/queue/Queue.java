package club.bayuan.queue;

public interface Queue {

  void add(Object o);

  Object delete();

  boolean isEmpty();
}
