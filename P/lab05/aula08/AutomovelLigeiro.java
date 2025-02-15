public class AutomovelLigeiro extends Veiculo {
    private String nQuadro;
    private int capBag;

    public AutomovelLigeiro(String matricula, String marca, String modelo, int potencia, String nQuadro,
            int capBag) {
        super(matricula, marca, modelo, potencia);
        this.nQuadro = nQuadro;
        this.capBag = capBag;
    }

    public String getNQuadro() {
        return nQuadro;
    }

    public int getCapBag() {
        return capBag;
    }

    @Override
    public String toString() {
        return "Automóvel ligeiro - " + "Matrícula: " + this.getMatricula() + "; Marca: " + this.getMarca()
                + "; Modelo: " + this.getModelo() + "; Potência: " + this.getPotencia() + "; Número do quadro: "
                + this.getNQuadro()
                + "; Capacidade da bagageira: " + this.getCapBag();
    }

}
