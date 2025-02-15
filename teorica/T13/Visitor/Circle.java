public class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    } 

    public void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }

    public int getRadius() {
        return radius;
    }
}
