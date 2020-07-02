import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

  private Node<K, V>[] entries = new Node[16];
  private List<V> values = new LinkedList<>();
  private Set<K> keys = new HashSet<>();

  private static class Node<K, V> {

    Node<K, V> prev;
    Node<K, V> next;
    Entry<K, V> entry;
  }

  private static class MyEntry<K, V> implements Entry<K, V> {

    K key;
    V value;

    public MyEntry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public K getKey() {
      return key;
    }

    @Override
    public V getValue() {
      return value;
    }

    @Override
    public V setValue(V value) {
      return this.value = value;
    }
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean containsKey(Object key) {
    return false;
  }

  @Override
  public boolean containsValue(Object value) {
    return false;
  }

  @Override
  public V get(Object key) {
    Node<K, V> entry = entries[key.hashCode() % (entries.length - 1)];
    while (entry != null) {
      if (entry.entry.getKey().equals(key)) {
        return entry.entry.getValue();
      } else {
        entry = entry.next;
      }
    }
    return null;
  }

  @Override
  public V put(K key, V value) {
    Node<K, V> entry = entries[key.hashCode() % (entries.length - 1)];
    if (entry == null) {
      Node<K, V> node = new Node<>();
      node.entry = new MyEntry<>(key, value);
      entries[key.hashCode() % (entries.length - 1)] = node;
      keys.add(key);
      values.add(value);
    } else {
      while (entry != null) {
        if (entry.entry.getKey().equals(key)) {
          entry.entry.setValue(value);
          keys.add(key);
          values.add(value);
          return value;
        } else {
          entry = entry.next;
        }
      }

      entry = entries[key.hashCode() % (entries.length - 1)];
      Node<K, V> newNode = new Node<>();
      newNode.entry = new MyEntry<>(key, value);
      newNode.next = entry;
      entry.prev = newNode;
      keys.add(key);
      values.add(value);
    }

    return value;
  }

  @Override
  public V remove(Object key) {
    return null;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {

  }

  @Override
  public void clear() {

  }

  @Override
  public Set<K> keySet() {
    return keys;
  }

  @Override
  public Collection<V> values() {
    return values;
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    return null;
  }
}
