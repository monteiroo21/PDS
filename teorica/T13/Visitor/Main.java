public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Retangle retangle = new Retangle(3, 4);
        
        InfoVisitor visitor = new InfoVisitor();
        
        circle.accept(visitor);
        retangle.accept(visitor);
       }
}
