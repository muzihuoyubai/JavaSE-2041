package club.banyuan;

public class DataSetRefineTest {

  public static void main(String[] args) {
    DataSetRefine dataSetRefine = new DataSetRefine(new StringMeasurer());

    dataSetRefine.add("1234");
    dataSetRefine.add("432112");
    System.out.println(dataSetRefine.getAverage());
    System.out.println(dataSetRefine.getMax());

    DataSetRefine dataSetRefine1 = new DataSetRefine(new CountryMeasurer());
    dataSetRefine1.add(new Country(123456));
    dataSetRefine1.add(new Country(222222));
    dataSetRefine1.add(new Country(111111));
    System.out.println(dataSetRefine1.getMax());
    System.out.println(dataSetRefine1.getAverage());
  }
}