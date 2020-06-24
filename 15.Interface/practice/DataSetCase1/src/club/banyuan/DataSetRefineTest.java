package club.banyuan;

public class DataSetRefineTest {

  public static void main(String[] args) {
    DataSetRefine dataSetRefine = new DataSetRefine(new StringMeasurer());

    dataSetRefine.add("1234");
    dataSetRefine.add("432112");
    System.out.println(dataSetRefine.getAverage());
    System.out.println(dataSetRefine.getMaximum());

    // DataSetRefine dataSetRefine1 = new DataSetRefine(new CountryMeasurer());
    DataSetRefine dataSetRefine1 = new DataSetRefine();
    dataSetRefine1.add(new Country(123456));
    dataSetRefine1.add(new Country(222222));
    dataSetRefine1.add(new Country(111111));
    System.out.println(dataSetRefine1.getMaximum());
    System.out.println(dataSetRefine1.getAverage());

    DataSetRefine dataSetRefine2 = new DataSetRefine(new RectangleMeasurer());
    dataSetRefine2.add(new Rectangle(12,33));
    dataSetRefine2.add(new Rectangle(12,33));
    dataSetRefine2.add(new Rectangle(12,33));
    System.out.println(dataSetRefine2.getMaximum());
    System.out.println(dataSetRefine2.getAverage());
  }
}