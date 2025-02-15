public class Conserva extends Produto {
    public Conserva(String nome, double peso) {
        super(nome, peso);
    }

    public void draw() {
        System.out.println(ident + "Conserva " + "\'" + nome + "\'" + " - Weight : " + peso);
    }
}
