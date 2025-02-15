public class PPEletrico extends PesadoPassageiros implements VeiculoEletrico {
    private int capCarga;
    private int capBateria;

    public PPEletrico(String matricula, String marca, String modelo, int consumo, String nQuadro,
            int nPassageiros, int capCarga, int capBateria) {
        super(matricula, marca, modelo, consumo, nQuadro, nPassageiros);
        this.capCarga = capCarga;
        this.capBateria = capBateria;
    }

    public int getCapCarga() {
        return capCarga;
    }

    public int getCapBateria() {
        return capBateria;
    }

    @Override
    public int autonomia() {
        return this.capBateria * this.getCapCarga();
    }

    @Override
    public void carregar(int percentagem) {
        this.capBateria += percentagem;
    }

    @Override
    public String toString() {
        return "PPElétrico - " + "Matrícula: " + this.getMatricula() + "; Marca: " + this.getMarca() + "; Modelo: "
                + this.getModelo() + "; Consumo: " + this.getPotencia() + "; Autonomia: " + this.autonomia()
                + "; Número do quadro: " + this.getNQuadro()
                + "; Número máximo de passageiros: "
                + this.getNPassageiros() + "; Capacidade de carga: " + this.getCapCarga() + "; Capacidade da bateria: "
                + this.getCapBateria();
    }
}
