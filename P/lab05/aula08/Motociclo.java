public class Motociclo extends Veiculo {
    private String tipo;

    public Motociclo(String matricula, String marca, String modelo, int potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        if (tipo.equals("desportivo") || tipo.equals("estrada")) {
            this.tipo = tipo;
        }
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Motociclo - " + "Matrícula: " + this.getMatricula() + "; Marca: " + this.getMarca() + "; Modelo: " + this.getModelo() + "; Potência: " + this.getPotencia() + "; Tipo: " + this.getTipo();
    }
}
