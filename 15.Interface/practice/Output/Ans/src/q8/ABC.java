package q8;

interface ABC {

  public void methodOne();

  public void methodTwo();
}

interface PQR extends ABC {

  // 可以有默认的实现方法
  default void methodOne() {

  }

  public void methodTwo();
}