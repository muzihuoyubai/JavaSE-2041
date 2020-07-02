package club.banyuan;

public class Main {

  public static void main(String[] args) {
    DataSet<Country> countryData = new DataSet<>();
    countryData.add(new Country(19920));
    countryData.add(new Country(20000));
    countryData.add(new Country(45000));
    countryData.add(new Country(1100));

    // 检查 最终的结果是 45000
    System.out.println(countryData.getMaximum().getPopulation());
  }
}
