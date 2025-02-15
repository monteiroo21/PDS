public class PassengerShip implements Ship {
    private String code;
    private String name;
    private int numPassengers;

    public PassengerShip(String code, String name, int numPassengers) {
        this.code = code;
        this.name = name;
        this.numPassengers = numPassengers;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String name() {
        return this.name;
    }

    public int getNumPassengers() {
        return this.numPassengers;
    }

    @Override
    public String toString() {
        return "PassengerShip [code=" + this.code() + ", name=" + this.name() + ", passengers=" + this.getNumPassengers() + "]";
    }
}
