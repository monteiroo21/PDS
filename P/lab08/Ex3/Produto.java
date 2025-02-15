public abstract class Produto implements ProdutoComposite {
    protected String nome;
    protected double peso;
    protected static final String ident = "";

    public Produto(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public String getIdent() {
        return ident;
    }

    public abstract void draw();

}
