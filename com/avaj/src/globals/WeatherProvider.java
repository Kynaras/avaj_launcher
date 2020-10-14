package globals;

import aircrafts.Coordinates;

public class WeatherProvider {
    private static final WeatherProvider WEATHER_PROVIDER = new WeatherProvider();
    private static String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};
   
    private WeatherProvider() {
        
    }
    public static WeatherProvider getProvider() {
        return WeatherProvider.WEATHER_PROVIDER;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        //The product of the coordinates is used, modulo the total weather types with the current weather being based on the remainder amount which is then used to map to the relevant array index
        int positionRemainder = ((coordinates.getLongitude() * coordinates.getLatitude() * coordinates.getHeight()) / 4) % weather.length;
       return weather[positionRemainder];
    }
}