
import java.text.NumberFormat;
import java.util.Locale;

class Country{
    protected String name;
    protected int population;
    protected String capital;

    public Country(String theName, int thePopulation, String theCapital){
        this.name = theName;
        this.population = thePopulation;
        this.capital = theCapital;
    }

    protected String getName() {
      return this.name;
    }

    protected String getPopulation() {
      NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
      String formattedPopulation = formatter.format(this.population);
      return formattedPopulation;
    }

    protected String getCapital() {
      return this.capital;
    }

    public void displayInfo(){
        String countryTemplate = """
        {country}, with its capital in {capital}, 
        it has a population of approximately {population}.
        """;
        String countryInfo = countryTemplate.replace("{country}", this.getName()).replace("{capital}", this.getCapital()).replace("{population}", this.getPopulation());
        System.out.println(countryInfo);
    }
}

class DevelopingCountry extends Country{
    private String mainExport;

    public DevelopingCountry(String theName, int thePopulation, String theCapital, String theMainExport){
        super(theName, thePopulation, theCapital);
        this.mainExport = theMainExport;
    }

    private String getMainExport() {
      return mainExport;
    }

    @Override
    public void displayInfo(){
        String developingCountryTemplate = """
        {country}, is a developing country with its capital in {capital}, 
        it has a population of approximately {population}, 
        and primarily exports {mainExport}.
        """;
        String developingCountryInfo = developingCountryTemplate.replace("{country}", super.getName()).replace("{capital}", super.getCapital()).replace("{population}", super.getPopulation()).replace("{mainExport}", this.getMainExport());
        System.out.println(developingCountryInfo);
    }

    public void displayParentInfo(){
      super.displayInfo();
    }
}

public class Main {
  public static void main(String[] args) {
    DevelopingCountry country = new DevelopingCountry("Malawi", 17000000, "Lilongwe", "Tobacco");
    country.displayInfo();
    country.displayParentInfo();
  }
}
