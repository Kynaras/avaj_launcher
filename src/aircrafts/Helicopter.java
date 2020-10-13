package aircrafts;


import interfaces.Flyable;
import tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    
    WeatherTower weatherTower;
    String type = "Helicopter";

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String message = "";
        switch(this.weatherTower.getWeather(coordinates)) {
            case "SUN":
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
            this.coordinates.setHeight((this.coordinates.getHeight() + 2) >= 100 ? 100: (this.coordinates.getHeight() + 2));
            message = "Sun is shining nicely. Shooting higher and further.";
            break;
            case "FOG":
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
            message = "Too much fog around here. Let's move a bit forward";
            break;
            case "RAIN":
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
            message = "The rain is difficult to navigate in. Moving on";
            break;
            case "SNOW":
            this.coordinates.setHeight(this.coordinates.getHeight() - 12);
            message = "The is out of contorl. Going lower!";
            break;
            default:
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
    
}