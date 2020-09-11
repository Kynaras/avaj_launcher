package aircrafts;

import interfaces.Flyable;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        switch(name) {
            case "JetPlane":
            return new JetPlane();
            case "Helicopter":
            return new Helicopter();
            case "Baloon":
            return new Baloon();
            
        }
    }
    
}

