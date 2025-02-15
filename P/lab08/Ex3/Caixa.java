import java.util.ArrayList;
import java.util.List;

public class Caixa extends Produto {
    private List<Produto> produtos;
    private double totalPeso;

    public Caixa(String nome, double peso) {
        super(nome, peso);
        this.produtos = new ArrayList<Produto>();
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public void remove(Produto produto) {
        produtos.remove(produto);
    }

    public double getTotalPeso() {
        return this.totalPeso;
    }

    public void setTotalPeso(double totalPeso) {
        this.totalPeso = totalPeso;
    }

    public double calcularPeso() {
        totalPeso = peso;
        for (Produto produto : produtos) {
            if (produto instanceof Caixa) {
                totalPeso += ((Caixa) produto).calcularPeso();
            } else {
                totalPeso += produto.getPeso();
            }
        }

        return totalPeso;
    }

    @Override
    public void draw() {
        System.out.println(
                ident + "* Caixa: " + "\'" + nome + "\'" + " [Weight: " + peso + " ; " + "Total: " + calcularPeso()
                        + "]");
        for (Produto produto : produtos) {
            produto.draw();
        }
    }
}
