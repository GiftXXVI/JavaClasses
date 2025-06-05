# Java Class Inheritance: Inheritance Example with Country and DevelopingCountry
This example demonstrates the concept of inheritance in Java using two classes: `Country` and its subclass `DevelopingCountry`.
## Imports
The following libraries are imported to support number formatting and locale-specific formatting:
```Java
import java.text.NumberFormat;
import java.util.Locale;
```
## Classes
There are two classes; `Country` and `DevelopingCountry`.
There are two classes in this example:
1. `Country` – A base class representing a general country.
2. `DevelopingCountry` – A subclass that extends `Country` and adds specific attributes.
### Country Class
This class defines the basic properties and behaviors of a country:
```Java
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
```
### Developing Country Class
This subclass adds a new attribute, `mainExport`, and overrides the `displayInfo()` method to include it:
```Java
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
```
### Demo
This class demonstrates how to create and use an instance of `DevelopingCountry`:
```Java
public class Main {
  public static void main(String[] args) {
    DevelopingCountry country = new DevelopingCountry("Malawi", 17000000, "Lilongwe", "Tobacco");
    country.displayInfo();
    country.displayParentInfo();
  }
}
```

### Summary
This example illustrates:
- Inheritance: `DevelopingCountry` inherits from `Country`.
- Method Overriding: `displayInfo()` is overridden to provide more specific output.
- Encapsulation: Fields are accessed through getter methods.
- Formatting: `Country.population` is formatted using `NumberFormat` for readability.
