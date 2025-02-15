

public class Container {
    private Portion portion;

    public Container(Portion portion) {
        this.portion = portion;
    }

    public Portion getPortion() {
        return portion;
    }

    public void setPortion(Portion portion) {
        this.portion = portion;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " with portion = " + getPortion().toString();
    }

    public static Container create(Portion portion) {
        switch (portion.getState().toString()+portion.getTemperature().toString()) {
            case "LiquidCOLD":
                return new PlasticBottle(portion);
            case "LiquidWARM":
                return new TermicBottle(portion);
            case "SolidCOLD":
                return new PlasticBag(portion);
            case "SolidWARM":
                return new Tupperware(portion);
            default:
                return null;
        }
    }
}
