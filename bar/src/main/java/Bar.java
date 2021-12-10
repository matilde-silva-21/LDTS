import java.util.ArrayList;
import java.util.List;

abstract public class Bar {

    List<BarObserver> observers;

    Bar(){
        observers = new ArrayList<>();
    }
    public abstract boolean isHappyHour();
    public abstract void startHappyHour();
    public abstract void endHappyHour();

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }
}
