

public class Food implements Portion{
    public void set(Temperature temperature, State state) {
        this.temperature = temperature;
        this.state = state;
    }
    public Temperature temperature;
    private State state;


    public Temperature getTemperature() {
        return temperature;
    }

    public State getState() {
        return state;
    }

    public String toString() {
        return this.getClass().getSimpleName() + ": Temperature " + this.temperature + ", State " + this.state;
    }
}
