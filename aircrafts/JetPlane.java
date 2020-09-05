package aircrafts;

import coordinates.Coordinates;
import interfaces.Flyable;

public class JetPlane extends Aircraft implements Flyable {

    public JetPlane (String name, Coordinates coordinates) {
        super(name, coordinates);
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