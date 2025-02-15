import java.util.List;
import java.util.ArrayList;

public class WeatherData {
    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void setMeasurements(int temperature, int humidity) {
        for (Observer observer : observers) {
            observer.setMeasurements(temperature, humidity);
        }
    }
}
