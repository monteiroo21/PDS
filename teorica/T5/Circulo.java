

public class Circulo extends Forma {
    private double radius;
    private String color;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circulo(String color, double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    public String color() {
        return color;
    }

    @Override
    public double area() {
        return (Math.PI * (Math.pow(radius, 2)));
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * radius;
    }    

    @Override
    public String toString() {
        return super.toString() + ", Perimetro = " + this.perimetro() + ", Area = " + this.area();
    }

    public boolean equals(Circulo otherCircle) {
        return radius == otherCircle.getRadius() && color == otherCircle.getColor();
    }
}
