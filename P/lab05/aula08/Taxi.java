public class Taxi extends AutomovelLigeiro {
    private String nLicenca;

    public Taxi(String matricula, String marca, String modelo, int potencia, String nQuadro, int capBag,
            String nLicenca) {
        super(matricula, marca, modelo, potencia, nQuadro, capBag);
        this.nLicenca = nLicenca;
    }

    public String getNLicenca() {
        return nLicenca;
    }

    @Override
    public String toString() {
        return "Táxi - " + "Matrícula: " + this.getMatricula() + "; Marca: " + this.getMarca()
                + "; Modelo: " + this.getModelo() + "; Potência: " + this.getPotencia() + "; Número do quadro: "
                + this.getNQuadro()
                + "; Capacidade da bagageira: " + this.getCapBag() + "; Número da licença: " + this.getNLicenca();
    }
}
