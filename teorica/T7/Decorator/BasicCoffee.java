package Decorator;

public class BasicCoffee implements Coffee {
    private Double price;
    private String decoration;

    public Double getCost() {
        return this.price;
    }

    public String getDescription() {
        return "Price: " + this.price + ", Decoration: " + this.decoration + "\n";
    }
}
