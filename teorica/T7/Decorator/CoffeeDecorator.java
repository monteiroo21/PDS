package Decorator;

public class CoffeeDecorator implements Coffee {
    private Double price;
    private String decoration;

    public Double getCost() {
        return this.price;
    }

    public String getDescription() {
        return "Price: " + this.price + ", Decoration: " + this.decoration + "\n";
    }

    public void coffeeDecorator() {
        
    }
}
