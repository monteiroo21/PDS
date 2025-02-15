import java.util.ArrayList;
import java.util.List;

public class EmpresaDeViaturas {
    private String nome;
    private String codigoPostal;
    private String email;
    private List<Veiculo> veiculos = new ArrayList<>();

    public EmpresaDeViaturas(String nome, String codigoPostal, String email) {
        this.nome = nome;
        this.codigoPostal = codigoPostal;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEmail(String email) {
        if (!email.matches(".+@.+\\.(pt|com|org)")) {
            System.out.println("Email inválido!");
            return false;
        } else {
            return true;
        }
    }

    public List<Veiculo> getVeiculosList() {
        return veiculos;
    }

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public Veiculo getVeiculo(String matricula) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMatricula() == matricula) {
                return veiculo;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Empresa de Aluguer - Nome: " + this.getNome() + "; Código Postal: " + this.getCodigoPostal()
                + "; Email: " + this.getEmail();
    }

    public Veiculo[] getStock() {
        return veiculos.toArray(new Veiculo[0]);
    }
}
