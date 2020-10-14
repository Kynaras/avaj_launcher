package aircrafts;

import interfaces.Flyable;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates vehicleCoordinates = new Coordinates(longitude, latitude, height);
        switch(type) {
            case "JetPlane":
            return new JetPlane(name, vehicleCoordinates);
            case "Helicopter":
            return new Helicopter(name, vehicleCoordinates);
            case "Baloon":
            return new Baloon(name, vehicleCoordinates);
            default:
                return null;
            
        }
    }
    
}

