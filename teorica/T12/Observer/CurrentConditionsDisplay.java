public class CurrentConditionsDisplay implements Observer {
    private int temperature;
    private int humidity;

    public CurrentConditionsDisplay(){
    }

    @Override
    public void setMeasurements(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        System.out.println(this.getClass().getCanonicalName() + "-> Updated temperature: " + temperature + " and humidity: " + humidity);
    }
    
}
