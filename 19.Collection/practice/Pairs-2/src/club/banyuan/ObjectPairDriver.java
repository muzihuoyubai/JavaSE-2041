package club.banyuan;

public class ObjectPairDriver {

  /**
   * 创建几个体育场对，然后打印容量最大的体育场名称。
   */
  public static void main(String[] args) {

    ObjectPair[] stadiums = new ObjectPair[3];
    stadiums[0] = new ObjectPair("五棵松", 25000);
    stadiums[1] = new ObjectPair("鸟巢", 109901);
    stadiums[2] = new ObjectPair("奥体中心", "66,233");

    System.out.println(stadiums[0]);
  }

  /**
   * 返回容量最大的体育场的名称。
   *
   * @param stadiums ObjectPairs的数组，其中包含一个体育管名称，还有一个数字作为体育馆容量
   * @return 容量最大的体育馆的名称
   */
  public static String largestStadium(ObjectPair[] stadiums) {

    return "";
  }

}