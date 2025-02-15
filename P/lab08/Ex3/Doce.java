public class Doce extends Produto {
    public Doce(String nome, double peso) {
        super(nome, peso);
    }

    public void draw() {
        System.out.println(ident + "Doce " + "\'" + nome + "\'" + " - Weight : " + peso);
    }
}
