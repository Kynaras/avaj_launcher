package aircrafts;

import interfaces.Flyable;
import tower.WeatherTower;
import utilities.SimulationWriter;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    private String type = "Baloon";

    protected Baloon(String name, Coordinates coordinates) {
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
            message = "Too much fog around here. Let's move lower";
            break;
            case "RAIN":
            this.coordinates.setHeight(this.coordinates.getHeight() - 5);
            message = "The rain is making it difficult to see. We're going lower!";
            break;
            case "SNOW":
            this.coordinates.setHeight(this.coordinates.getHeight() - 15);
            message = "The snow is too much! Heading down!";
            break;
            default:
                break;
        }
        this.logWeather(this.type, this.name, this.id, message);
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            SimulationWriter.add(type + "#" + this.name + "(" + this.id + ") " + "landing.");
            SimulationWriter.add("Tower update: " + type + "#" + this.name + "(" + this.id + ") " + "has been deregistered from the tower");

        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        SimulationWriter.add("Tower update: " + type + "#" + this.name + "(" + this.id + ") " + "has been registered with the tower");
    }

    
}