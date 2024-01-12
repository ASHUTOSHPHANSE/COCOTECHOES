import java.util.Random;
import java.util.*;

class VisitEntry {
    int userId;
    String timeOfDay;
    int timeSpentMinutes;

    public VisitEntry(int userId, String timeOfDay, int timeSpentMinutes) {
        this.userId = userId;
        this.timeOfDay = timeOfDay;
        this.timeSpentMinutes = timeSpentMinutes;
    }
}

class CityData {
    String cityName;
    VisitEntry[] visitEntries;

    public CityData(String cityName, VisitEntry[] visitEntries) {
        this.cityName = cityName;
        this.visitEntries = visitEntries;
    }
}
public class VisitDataGenerator {
    public static void main(String[] args) {
        int numCities = 5;
        int numEntriesPerCity = 100;

        CityData[] citiesData = generateData(numCities, numEntriesPerCity);


        System.out.println("Time of day with the most unique users: " +  Arrays.toString(citiesData));


    }

    private static CityData[] generateData(int numCities, int numEntriesPerCity) {
        String[] cities = {"Pune", "Mumbai", "Banglore", "Delhi", "Hyderabad"};

        CityData[] citiesData = new CityData[numCities];
        for (int i = 0; i < numCities; i++) {
            VisitEntry[] cityEntries = generateCityData(cities[i], numEntriesPerCity);
            citiesData[i] = new CityData(cities[i], cityEntries);
        }

        return citiesData;
    }

    private static VisitEntry[] generateCityData(String cityName, int numEntries) {
        VisitEntry[] cityEntries = new VisitEntry[numEntries];
        Random random = new Random();

        for (int i = 0; i < numEntries; i++) {
            int userId = random.nextInt(30) + 1;
            String timeOfDay = getRandomTimeOfDay();
            int timeSpentMinutes = random.nextInt(116) + 5;

            cityEntries[i] = new VisitEntry(userId, timeOfDay, timeSpentMinutes);
        }

        return cityEntries;
    }

    private static String getRandomTimeOfDay() {
        String[] timesOfDay = {"morning", "noon", "evening", "night"};
        return timesOfDay[new Random().nextInt(timesOfDay.length)];
    }


}
