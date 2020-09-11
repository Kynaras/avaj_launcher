package globals;

import coordinates.Coordinates;

public class WeatherProvider {
    private static final WeatherProvider WEATHER_PROVIDER = new WeatherProvider();
    String[] weatherTypes = {"SUN", "FOG", "RAIN", "SNOW"};
    String weather;
    private WeatherProvider() {
        
    }
    public static WeatherProvider getProvider() {
        return WeatherProvider.WEATHER_PROVIDER;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        //The product of the coordinates is used, modulo the total weather types with the current weather being based on the remainder amount which is then used to map to the relevant array index
        int positionRemainder = (coordinates.longitude * coordinates.latitude * coordinates.height) % weatherTypes.length;
       return weatherTypes[positionRemainder];
    }
}