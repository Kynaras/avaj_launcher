
package tower;

import java.util.ArrayList;
import java.util.List;

import interfaces.Flyable;

public class Tower {

    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> deregisterList = new ArrayList<>();
    public void register(Flyable flyable){
        observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        this.deregisterList.add(flyable); 
    }

    public void requestUnregister(Flyable flyable) {
        this.deregisterList.add(flyable);
    }

    private void auditObservers(){
        for (Flyable observer: deregisterList) {
            observers.remove(observer);
        }
        this.deregisterList.clear();
    }

    protected void conditionsChanged() {
        this.auditObservers();
        for (Flyable observer : observers) {
            observer.updateConditions();  
         }
    }
}