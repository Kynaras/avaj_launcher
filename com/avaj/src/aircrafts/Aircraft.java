package aircrafts;

import utilities.SimulationWriter;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        Aircraft.idCounter++;
        return Aircraft.idCounter;
    }
    
    protected void logWeather(String type, String name, long id, String msg){
        SimulationWriter.add(type + "#" + name + "(" + id + "): " + msg);
    }
}