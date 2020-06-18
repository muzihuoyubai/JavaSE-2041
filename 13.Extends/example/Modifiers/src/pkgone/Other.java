package pkgone;

public class Other {

  public static void main(String[] args) {

    Son son = new Son();
    System.out.println(son.defaultField);
    son.defaultMethod();

    System.out.println(son.protectedField);
    son.protectedMethod();

    pkgtwo.Son otherPackageSon = new pkgtwo.Son();
    System.out.println(otherPackageSon.protectedField);
    otherPackageSon.protectedMethod();
  }
}
