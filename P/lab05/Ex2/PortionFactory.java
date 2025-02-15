

public class PortionFactory {
    public static Portion create(String food, Temperature temperature) {
        switch (food+temperature.toString()) {
            case "MeatCOLD":
                return new Tuna(temperature);
            case "MeatWARM":
                return new Pork(temperature);
            case "BeverageCOLD":
                return new FruitJuice(temperature, "Orange");
            case "BeverageWARM":
                return new Milk(temperature);
            default:
                return null;
        }
    }
}
