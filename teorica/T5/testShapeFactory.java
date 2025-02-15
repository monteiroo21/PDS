

public class testShapeFactory {
    public static void main(String[] args) {
        Forma forma1 = ShapeFactory.createShape("Circulo");
        System.out.println(forma1.area());
        Forma forma2 = ShapeFactory.createShape("Retangulo");
        System.out.println(forma2.area());
        Forma forma3 = ShapeFactory.createShape("Triangulo");
        System.out.println(forma3.area());
    }
}
