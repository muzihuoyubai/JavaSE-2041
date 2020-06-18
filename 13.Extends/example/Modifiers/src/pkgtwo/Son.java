package pkgtwo;

import pkgone.Father;

public class Son extends Father {

  public static void main(String[] args) {
    Son son = new Son();
    // son.privateField;
    // son.privateMethod();

    // 子类和父类不再同一个包路径，无法使用父类中定义的默认访问权限的成员和方法
    // System.out.println(son.defaultField);
    // son.defaultMethod();

    System.out.println(son.protectedField);
    son.protectedMethod();
  }
}
