public class CargoShip implements Ship {
    private String code;
    private String name;
    private double load;

    public CargoShip(String code, String name, double load) {
        this.code = code;
        this.name = name;
        this.load = load;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String name() {
        return this.name;
    }

    public double getLoad() {
        return this.load;
    }

    @Override
    public String toString() {
        return "CargoShip [code=" + this.code() + ", name=" + this.name() + ", cargo=" + this.getLoad() + "]";
    }
}
