package pkgone;

public class Son extends Father {

  public static void main(String[] args) {
    Son son = new Son();
    // son.privateField;
    // son.privateMethod();

    System.out.println(son.defaultField);
    son.defaultMethod();
  }
}
