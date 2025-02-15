

public class Testing {
    public static void main(String args[]) {
        System.out.println("Comparação de círculos: ");
        Circulo C1 = new Circulo("Azul", Math.PI);
        Circulo C2 = new Circulo("Verde", 3);
        Circulo C3 = new Circulo("Vermelho", Math.PI);
        Circulo C4 = new Circulo("Azul", Math.PI);
        System.out.println(C1.toString());
        System.out.println(C2.toString());
        System.out.println(C3.toString());
        System.out.println(C4.toString());
        System.out.println(C1.equals(C2)); // false
        System.out.println(C1.equals(C3)); // false
        System.out.println(C1.equals(C4)); // true
        System.out.println();

        System.out.println("Comparação de triângulos: ");
        Triangulo T1 = new Triangulo("Azul", 4, 3, 2);
        Triangulo T2 = new Triangulo("Verde", 6, 3, 1);
        Triangulo T3 = new Triangulo("Vermelho",3,2,4);
        Triangulo T4 = new Triangulo("Azul", 4,3,2);
        System.out.println(T1.toString());
        System.out.println(T2.toString());
        System.out.println(T3.toString());
        System.out.println(T4.toString());
        System.out.println(T1.equals(T2)); // false
        System.out.println(T1.equals(T3)); // false
        System.out.println(T1.equals(T4)); // true
        System.out.println();

        System.out.println("Comparação de retângulos:");
        Retangulo R1 = new Retangulo("Azul", 5, 7);
        Retangulo R2 = new Retangulo("Verde", 7, 5);
        Retangulo R3 = new Retangulo("Vermelho", 4, 8);
        Retangulo R4 = new Retangulo("Vermelho", 4, 8);
        System.out.println(R1.toString());
        System.out.println(R2.toString());
        System.out.println(R3.toString());
        System.out.println(R4.toString());
        System.out.println(R1.equals(R2)); //false
        System.out.println(R1.equals(R3)); //false
        System.out.println(R3.equals(R4)); //true
    }
}
