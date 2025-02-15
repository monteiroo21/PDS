public class PesadoMercadorias extends Veiculo {
    private String nQuadro;
    private double cargaMax;

    public PesadoMercadorias(String matricula, String marca, String modelo, int potencia, String nQuadro, double peso,
            double cargaMax) {
        super(matricula, marca, modelo, potencia);
        this.nQuadro = nQuadro;
        this.cargaMax = cargaMax;
    }

    public String getNQuadro() {
        return nQuadro;
    }

    public double getCargaMax() {
        return cargaMax;
    }

    @Override
    public String toString() {
        return "Pesado de Mercadorias - " + "Matrícula: " + this.getMatricula() + "; Marca: " + this.getMarca()
                + "; Modelo: " + this.getModelo() + "; Potência: " + this.getPotencia() + "; Número do quadro: "
                + this.getNQuadro()
                + "; Carga máxima: " + this.getCargaMax();
    }
}
