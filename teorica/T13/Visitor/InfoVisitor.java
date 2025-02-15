public class InfoVisitor implements Visitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("Circle with radius: " + circle.getRadius());
    }

    @Override
    public void visitRetangle(Retangle retangle) {
        System.out.println("Rectangle with width: " + retangle.getWidth() + " and height: " + retangle.getHeight());
    }
}
