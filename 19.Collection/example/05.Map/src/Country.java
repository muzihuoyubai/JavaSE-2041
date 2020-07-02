public class Country {

  private long population;
  private String code;

  public Country(long population) {
    this.population = population;
  }

  public Country(long population, String code) {
    this.population = population;
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public long getPopulation() {
    return population;
  }

  public void setPopulation(long population) {
    this.population = population;
  }

  @Override
  public String toString() {
    return "Country{" +
        "population=" + population +
        ", code='" + code + '\'' +
        '}';
  }
}
