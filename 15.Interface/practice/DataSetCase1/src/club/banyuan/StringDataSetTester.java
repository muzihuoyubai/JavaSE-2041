package club.banyuan;

public class StringDataSetTester {

  public static void main(String[] args) {
    StringDataSet stringDataSet = new StringDataSet();
    stringDataSet.add("1234");
    stringDataSet.add("123456");
    stringDataSet.add("1234asdf");
    System.out.println(stringDataSet.getAverage());
    System.out.println(stringDataSet.getMaximumStr());
  }
}
