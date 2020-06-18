public class Son extends Father {

  public Son() {
    super("name");
    System.out.println("创建Son对象");
  }

  public Son(String name) {
    super("name");
    System.out.println("子类一个参数的构造方法");
  }

  public static void main(String[] args) {
    Son son = new Son();
    System.out.println(son.getFatherField());

    Son nameSon = new Son("name");

  }
}
