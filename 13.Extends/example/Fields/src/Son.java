public class Son extends Father {

  public static void main(String[] args) {
    Son son = new Son();
    Father father = new Father();
    son.field = "sonField";
    father.field = "fatherField";

    System.out.println(son.field);
    System.out.println(son.getField());
    System.out.println(father.getField());
  }
}
