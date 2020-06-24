package club.banyuan;

public class Country implements Measurable {

  private double population;

  public Country(double population) {
    this.population = population;
  }

  public double getPopulation() {
    return population;
  }

  @Override
  public double getMeasure() {
    return getPopulation();
  }


  @Override
  public String toString() {
    return "Country{" +
        "population=" + population +
        '}';
  }
}
