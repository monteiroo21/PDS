public class PesadoPassageiros extends Veiculo {
    private String nQuadro;
    private int nPassageiros;

    public PesadoPassageiros(String matricula, String marca, String modelo, int potencia, String nQuadro,
            int nPassageiros) {
        super(matricula, marca, modelo, potencia);
        this.nQuadro = nQuadro;
        this.nPassageiros = nPassageiros;
    }

    public String getNQuadro() {
        return nQuadro;
    }

    public int getNPassageiros() {
        return nPassageiros;
    }

    @Override
    public String toString() {
        return "Pesado de passageiros - " + "Matrícula: " + this.getMatricula() + "; Marca: " + this.getMarca()
                + "; Modelo: " + this.getModelo() + "; Potência: " + this.getPotencia() + "; Número do quadro: "
                + this.getNQuadro()
                + "; Número máximo de passageiros: " + this.getNPassageiros();
    }
}
