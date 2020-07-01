package club.banyuan;

public class Main {

  public static void main(String[] args) {
    ArrayList arrayList = new ArrayList();
    arrayList.add(new Item());
    arrayList.add(new Item());
    arrayList.add(new OtherItem());
    arrayList.add(new Item());
    arrayList.add(new Item());
    arrayList.add(new Item());

    Object item = arrayList.get(2);
    ((Item)item).itemMethod();
  }
}
