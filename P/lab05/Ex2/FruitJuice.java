

public class FruitJuice extends Food{
    private String fruit;
    public FruitJuice(Temperature temperature, String fruit) {
        super();
        super.set(Temperature.COLD, State.Liquid);
        this.fruit = fruit;
    }

    @Override public String toString() {
        return this.getClass().getSimpleName() + ": " + this.fruit + ", Temperature " + this.temperature + ", State " + this.getState();
    }
}
