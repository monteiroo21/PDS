public class VehicleFactory {
    public static Veiculo createMotociclo(String matricula, String marca, String modelo, int consumo, String tipo) {
        return new Motociclo(matricula, marca, modelo, consumo, tipo);
    }

    public static Veiculo createAutomovelLigeiro(String matricula, String marca, String modelo, int potencia,
            String nQuadro, int cilindrada) {
        return new AutomovelLigeiro(matricula, marca, modelo, potencia, nQuadro, cilindrada);
    }

    public static Veiculo createTaxi(String matricula, String marca, String modelo, int potencia, String nQuadro,
            int capBag, String licenca) {
        return new Taxi(matricula, marca, modelo, potencia, nQuadro, capBag, licenca);
    }

    public static Veiculo createPPEletrico(String matricula, String marca, String modelo, int consumo, String nQuadro,
            int nPassageiros, int capCarga, int capBateria) {
        return new PPEletrico(matricula, marca, modelo, consumo, nQuadro, nPassageiros, capCarga, capBateria);
    }

    public static Veiculo createALEletrico(String matricula, String marca, String modelo, int consumo, String nQuadro,
            int autonomia, int capCarga, int capBateria) {
        return new ALEletrico(matricula, marca, modelo, consumo, nQuadro, autonomia, capCarga, capBateria);
    }

    public static Veiculo createPesadoMercadorias(String matricula, String marca, String modelo, int potencia,
            String nQuadro, int capCarga, int capReboque) {
        return new PesadoMercadorias(matricula, marca, modelo, potencia, nQuadro, capCarga, capReboque);
    }

    public static Veiculo createPesadoPassageiros(String matricula, String marca, String modelo, int potencia,
            int capacidade,
            String nQuadro, int nPassageiros) {
        return new PesadoPassageiros(matricula, marca, modelo, potencia, nQuadro, nPassageiros);
    }
}
