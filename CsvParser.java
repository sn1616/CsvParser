import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;

public class CsvParser {
    private String filename;

    public CsvParser(String filename) {
        this.filename = filename;
    }

    public List<CityTemperature> parse() throws IOException {
        List<CityTemperature> cities = new ArrayList<>();
        ProcessBuilder pb = new ProcessBuilder("git", "show", "HEAD:../outr/data.csv");
        Process p = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;
        boolean firstLine = true;
        while ((line = br.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] parts = line.split(",");
            String city = parts[0];
            int temperature = Integer.parseInt(parts[1]);
            cities.add(new CityTemperature(city, temperature));
        }
        br.close();
        return cities;
    }
}

class CityTemperature {
    private String city;
    private int temperature;

    public CityTemperature(String city, int temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public int getTemperature() {
        return temperature;
    }
}
