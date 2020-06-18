public class Father {

  private String fatherField = "fatherField";

  // public Father() {
  //   System.out.println("创建一个Father对象");
  // }

  public Father(String name) {
    System.out.println("父类一个参数的构造方法");
  }

  public void setFatherField(String fatherField) {
    this.fatherField = fatherField;
  }

  public String getFatherField() {
    return fatherField;
  }
}
