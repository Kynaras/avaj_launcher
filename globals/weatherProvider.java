package globals;

import coordinates.Coordinates;

public class weatherProvider {
    private static final weatherProvider WEATHER_PROVIDER;
    String weatherTypes [] = {"SUN", "FOG", "RAIN", "SNOW"};
    String weather;
    private weatherProvider() {
        
    }
    public static weatherProvider getProvider() {
        return WEATHER_PROVIDER;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        //The product of the coordinates is used, modulo the total weather types with the current weather being based on the remainder amount which is then used to map to the relevant array index
        int positionRemainder = (coordinates.longitude * coordinates.latitude * coordinates.height) % weather.length;
       return weatherTypes[positionRemainder];
    }
        
    }
}