

public class ShapeFactory {
    public static Forma createShape(String type) {
        if (type.equals("Retangulo")) {
            return new Retangulo("Vermelho", 4, 8);
        } else if (type.equals("Circulo")) {
            return new Circulo("Azul", Math.PI);
        } else if (type.equals("Triangulo")) {
            return new Triangulo("Azul", 4, 3, 2);
        } else {
            return null;
        }
    }
}
