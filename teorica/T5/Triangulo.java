

public class Triangulo extends Forma {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private String color;

    public double getLadoA() {
        return ladoA;
    }

    public double getLaboB() {
        return ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

    public Triangulo(String color, double ladoA, double ladoB, double ladoC){
        super(color);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public String color() {
        return color;
    }

    @Override
    public double area() {
        return Math.sqrt((perimetro() * (perimetro() - ladoA) * (perimetro() - ladoB) * (perimetro() - ladoC)));
    }

    @Override
    public double perimetro() {
        return ladoA + ladoB + ladoC;
    }    

    @Override
    public String toString() {
        return super.toString() + ", Perimetro = " + this.perimetro() + ", Area = " + this.area();
    }
    
    public boolean equals(Triangulo outroTriangulo) {
        return ((ladoA == outroTriangulo.ladoA && ladoB == outroTriangulo.ladoB && ladoC == outroTriangulo.ladoC) || (ladoA == outroTriangulo.ladoB && ladoB == outroTriangulo.ladoA && ladoC == outroTriangulo.ladoC) || (ladoA == outroTriangulo.ladoA && ladoB == outroTriangulo.ladoC && ladoC == outroTriangulo.ladoB) || (ladoA == outroTriangulo.ladoC && ladoB == outroTriangulo.ladoB && ladoC == outroTriangulo.ladoA) || (ladoA == outroTriangulo.ladoB && ladoB == outroTriangulo.ladoC && ladoC == outroTriangulo.ladoA) || (ladoA == outroTriangulo.ladoC && ladoB == outroTriangulo.ladoA && ladoC == outroTriangulo.ladoB) && color == outroTriangulo.getColor()); 
    }
}
