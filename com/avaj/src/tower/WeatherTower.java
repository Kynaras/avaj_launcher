package tower;

import aircrafts.Coordinates;
import globals.WeatherProvider;

public class WeatherTower extends Tower {

    private WeatherProvider weatherProvider = WeatherProvider.getProvider();
    public String getWeather (Coordinates coordinates) {
       return this.weatherProvider.getCurrentWeather(coordinates);

    }
    
   void changeWeather() {
       this.conditionsChanged();
    }

    
}