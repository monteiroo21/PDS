

public class Retangulo extends Forma {
    private double length;
    private double heigth;
    private String color;

    public double getLength() {
        return length;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public Retangulo(String color, double length, double heigth) {
        super(color);
        this.heigth = heigth;
        this.length = length;
    }

    @Override
    public double area() {
        return length * heigth;
    }

    @Override
    public double perimetro() {
        return (2 * length) + (2 * heigth);
    }   
    
    @Override
    public String color() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + ", Perimetro = " + this.perimetro() + ", Area = " + this.area();
    }

    public boolean equals(Retangulo outroRetangulo) {
        return ((length == outroRetangulo.getLength() && heigth == outroRetangulo.getHeigth()) && color == outroRetangulo.getColor());
    }
}
