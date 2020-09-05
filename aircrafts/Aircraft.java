package aircrafts;

import coordinates.Coordinates;

public class Aircraft {
    long id;
    String name;
    Coordinates coordinates;
    long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return long;
    }
    
}