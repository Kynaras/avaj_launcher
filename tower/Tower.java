package tower;

import java.util.ArrayList;
import java.util.List;

import interfaces.Flyable;

public class Tower {

    private List<Flyable> observers = new ArrayList<>();
    public void register(Flyable flyable){
        observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        
    }
    protected void conditionsChanged() {
        
    }
}