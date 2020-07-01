package club.banyuan;


import javax.print.attribute.standard.MediaSize.Other;

public class BoxDemo {

  public static void main(String[] args) {
    Box box = new Box();
    box.setItem(new Item());
    box.setItem(new OtherItem());

    Object item = box.getItem();
    ((Item) item).itemMethod();

    GenericBox<Item> genericBox = new GenericBox<>();
    genericBox.setItem(new Item());
    // genericBox.setItem(new OtherItem());

    Item item1 = genericBox.getItem();

    GenericBox<OtherItem> otherItemGenericBox = new GenericBox<>();

    otherItemGenericBox.setItem(new OtherItem());
    // otherItemGenericBox.setItem(new Item());
    // otherItemGenericBox.setItem(new Object());
  }
}
