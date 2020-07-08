import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {

  public static void main(String[] args) {

    // Collection<String> collection = new ArrayList<>();
    // Collection<String> collection = new LinkedList<>();
    // Collection<String> collection = new HashSet<>();
    // Collection<String> collection = new LinkedHashSet<>();
    // Collection<String> collection = new CopyOnWriteArrayList<>();
    // Collection<String> collection = new CopyOnWriteArraySet<>();

    List<Collection<String>> target = new ArrayList<>();
    target.add(new ArrayList<>());
    target.add(new LinkedList<>());
    target.add(new HashSet<>());

    // ConcurrentHashMap
    target.add(new CopyOnWriteArrayList<>());
    target.add(new CopyOnWriteArraySet<>());

    Collection<String> collection = target.get(3);

    List<Thread> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      int index = i;
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int j = 0; j < 10; j++) {
            collection.add("线程" + index + " " + j);
          }
        }
      });
      thread.start();
      list.add(thread);
    }

    for (Thread thread : list) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(collection.size());
  }
}
