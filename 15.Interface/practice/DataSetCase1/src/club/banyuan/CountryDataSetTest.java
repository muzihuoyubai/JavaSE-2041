package club.banyuan;

public class CountryDataSetTest {

  public static void main(String[] args) {
    CountryDataSet countryData = new CountryDataSet();
    countryData.add(new Country(19920));
    countryData.add(new Country(20000));
    countryData.add(new Country(45000));
    countryData.add(new Country(1100));
    Country max = countryData.getMaximum();
    System.out.println("最高人口数为: " + max.getPopulation());
    System.out.println(countryData.getAverage());
  }
}