class Practice {

  public static void main(String[] args) {
    /**
     * 验证当float类型变量中保存了超出了int所能表示的范围的数字，将这个变量强制转换为int数据类型后，int数据类型变量中保存的值是多少
     */
    float floatOne = 3.14E15F;
    int intOne = (int) floatOne;
    System.out.println("float数值是：" + floatOne);
    System.out.println("转换成int的数值是：" + intOne); // 2147483647 转换为int所能表示的最大的数值

    /**
     * 编写示例证明`||`会出现短路而`|`是不会短路的
     */
    int count = 1;
    if (true || ++count > 1) {
      System.out.println("短路");
    }
    System.out.println("count = " + count); // count = 1

    count = 1;
    if (true | ++count > 1) {
      System.out.println("不会短路");
    }
    System.out.println("count = " + count); // count=2


  }
}