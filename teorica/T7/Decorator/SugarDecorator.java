package Decorator;

public class SugarDecorator extends CoffeeDecorator {
    private Coffee wrapper;

    public Double getCost() {
        return super.getCost();
    }

    public String getDescription() {
        return super.getDescription();
    }

    public void coffeeDecorator(Coffee wrapper) {
        this.wrapper = wrapper;
    }
}
