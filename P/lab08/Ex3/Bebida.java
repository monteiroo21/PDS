public class Bebida extends Produto {
    public Bebida(String nome, double peso) {
        super(nome, peso);
    }

    public void draw() {
        System.out.println(ident + "Bebida " + "\'" + nome + "\'" + " - Weight : " + peso);
    }
}
