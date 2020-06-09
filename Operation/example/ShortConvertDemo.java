/**
 * 可以将此代码编译的class文件使用idea进行反编译
 * 查看编译器的优化
 */
class Demo {

  public static void main(String[] args) {
    short shortOne = 1;
    short shortTwo = 1;
    // shortTwo = shortOne + shortTwo; // 编译报错
    shortTwo += shortOne; // 查看编译器优化结果
    short three = (short) 1 + (short) 2;
    System.out.println(three);
  }

}
