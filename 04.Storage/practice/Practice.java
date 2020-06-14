class Practice {

  public static void main(String[] args) {

    /**
     * 如果要保存7天时间的毫秒值（7x24x60x60x1000=604800000），需要使用什么数据类型，请选用合理的变量名称，将定义和初始化过程记录到答案中。
     */
    int oneWeekMillisecond = 7 * 24 * 60 * 60 * 1000;

    /**
     * 如果要保存30天时间的毫秒值(30x24x60x60x1000=2592000000)，需要使用什么数据类型，请选用合理的变量名称，将定义和初始化过程记录到答案中
     */
    long oneMonthMillisecond = 30 * 24 * 60 * 60 * 1000L;

    /**
     * 如何验证小数字面量默认值是double数据类型的，请将代码说明记录到答案中
     */
    // 因为float能表示最大的数量级为e38，下面的字面量已经超出了float表示范围，
    // 但是编译不报错，说明字面量默认是double数据类型
    System.out.println(3.14E39);
    // 如下代码，如果使用F标识为float字面量，则编译报错
    // System.out.println(3.14E39F); // 编译报错
    // 如下代码，使用D标识为double字面量，编译通过
    System.out.println(3.14E39D);

    /**
     * 如何证明数组的length是final的，如何证明数组length是int类型
     */
    int[] arr1 = new int[3];
    // 对数组length成员重新赋值，编译报错。证明是final类型，无法再次进行赋值
    // arr1.length = 3; // 编译报错

    // 使用超过int范围的数字字面量创建数组，编译报错。说明数组length是int类型
    // int [] arr2 = new int[0xFFFFFFFF]; // 编译报错

    /**
     * 尝试定义并初始化一个二维数组，第一行有3个元素{"你","我","他"}，第二行有5个元素{"金","木","水","火","土"}，第三行有2个元素{"天","地"}，请选用合适的数据类型定义，注意第二维度数组的长度是不同的
     */
    // 创建一个一维长度是3的二维数组，相当于创建了3行，然后给每一行创建一个一维数组
    String[][] twoDimensionArr = new String[3][];
    twoDimensionArr[0] = new String[]{"你", "我", "他"};
    twoDimensionArr[1] = new String[]{"金", "木", "水", "火", "土"};
    twoDimensionArr[2] = new String[]{"天", "地"};
  }
}