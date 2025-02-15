

public abstract class Forma {
    private String color;

    public abstract String color();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Forma(String color) {
        this.color = color;
    }

    public abstract double area();
    public abstract double perimetro();

    public String toString() {
        return "Color: " + this.getColor();
    }
}
