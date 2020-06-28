package club.banyuan;

public class NormalClass {

  public static void main(String[] args) {
    Elephant elephant = new Elephant();

    // 创建了一个大象类的子类对象
    Elephant e = new Elephant() {
      @Override
      public void elephantMethod() {
        // System.out.println(height); 不能访问私有的成员
        super.elephantMethod();
      }
    };
  }
}
