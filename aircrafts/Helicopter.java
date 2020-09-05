package aircrafts;

import coordinates.Coordinates;
import interfaces.Flyable;

public class Helicopter extends Aircraft implements Flyable {

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void updateConditions() {
        // TODO Auto-generated method stub

    }

    @Override
    public void registerTower() {
        // TODO Auto-generated method stub

    }
    
}