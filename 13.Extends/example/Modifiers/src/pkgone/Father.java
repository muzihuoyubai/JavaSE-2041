package pkgone;

public class Father {

  private String privateField = "fatherPrivate";
  protected String protectedField = "fatherProtected";

  protected void protectedMethod() {
    System.out.println("fatherProtectedMethod");
  }

  private void privateMethod() {
    System.out.println("fatherPrivateMethod");
  }

  String defaultField = "fatherDefault";

  void defaultMethod() {
    System.out.println("fatherDefaultMethod");
  }
}
