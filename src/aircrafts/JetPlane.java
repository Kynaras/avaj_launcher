package aircrafts;

import interfaces.Flyable;
import tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    String type = "Jetplane";

    public JetPlane (String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    @Override
    public void updateConditions() {
        String message = "";
        switch(this.weatherTower.getWeather(coordinates)) {
            case "SUN":
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
            this.coordinates.setHeight((this.coordinates.getHeight() + 4) >= 100 ? 100: (this.coordinates.getHeight() + 4));
            message = "It is mighty sunny here! Let's go higher and further!";
            break;
            case "FOG":
            this.coordinates.setHeight(this.coordinates.getHeight() - 3);
            message = "Too much fog around here. Lowering altitude";
            break;
            case "RAIN":
            this.coordinates.setHeight(this.coordinates.getHeight() - 5);
            message = "The rain is forcing us downward";
            break;
            case "SNOW":
            this.coordinates.setHeight(this.coordinates.getHeight() - 15);
            message = "The snow is out of control. Getting lower";
            break;
            default:
            message = "The weather is strangely.. non-descript?";
                break;
        }
        this.logWeather(this.type, this.name, this.id, message);
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            System.out.println(type + "#" + this.name + "(" + this.id + ") " + "landing");
            System.out.println("Tower update: " + type + "#" + this.name + "(" + this.id + ") " + "has been deregistered from the tower");
        }

    }
    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower update: " + type + "#" + this.name + "(" + this.id + ") " + "has been registered with the tower");
    }

    public WeatherTower getWeatherTower() {
        return weatherTower;
    }

    public void setWeatherTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
    
}