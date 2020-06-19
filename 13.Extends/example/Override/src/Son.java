public class Son extends Father {

  /**
   * 父类中私有方法不构成重写
   */
  private void privateMethod() {
    defaultMethod();
  }

  /**
   * 从写方法的访问权限修饰符，必须要大于等于父类的访问权限
   * 返回值必须和父类的一致
   */
  @Override
  void defaultMethod() {
    System.out.println("重写方法");
    // defaultMethod(); // 执行子类中重写的方法
    // super.defaultMethod(); 使用super调用父类中被重写的方法
    // this.defaultMethod(); 如果不存在重写，和super调用的是同一个方法，如果重写，则调用重写的方法
  }

  public static void main(String[] args) {
    Son son = new Son();
    son.defaultMethod(); // 执行子类中重写的方法
  }
}
