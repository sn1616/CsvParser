import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvParser parser = new CsvParser("data.csv");
        try {
            List<CityTemperature> cities = parser.parse();
            for (CityTemperature city : cities) {
                System.out.println(city.getCity() + " has a temperature of " + city.getTemperature() + " degrees.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
