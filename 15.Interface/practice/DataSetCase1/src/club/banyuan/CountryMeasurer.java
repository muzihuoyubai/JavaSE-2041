package club.banyuan;

public class CountryMeasurer implements Measurer {

  double measureCountry(Country country) {
    return country.getPopulation();
  }

  @Override
  public double measure(Object o) {
    return ((Country) o).getPopulation();
  }
}
