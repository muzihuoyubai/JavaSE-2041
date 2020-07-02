import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

  // 线性表
  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("123");
    arrayList.set(0,"1");

    List<String> list = new ArrayList<>();

    // list = new LinkedList<>();

    list.add("123");
    list.add(0,"abc"); // 1 可以，2 报错

    System.out.println(list);


    List<Integer> retainAllDemo = new ArrayList<>();
    retainAllDemo.add(1);
    retainAllDemo.add(2);
    retainAllDemo.add(3);
    retainAllDemo.add(4);
    retainAllDemo.add(5);

    List<Integer> retainAllDemo2 = new ArrayList<>();
    retainAllDemo2.add(2);
    retainAllDemo2.add(3);
    // retainAllDemo2.add(4);

    // boolean b = retainAllDemo.retainAll(retainAllDemo2);
    // System.out.println(b);
    // System.out.println(retainAllDemo);

    boolean b = retainAllDemo.removeAll(retainAllDemo2);
    System.out.println(retainAllDemo);

  }
}
