public class Veiculo implements KmPercorridosInterface {
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;
    private int kmstotal = 0;
    private int kmstemp = 0;

    public Veiculo(String matricula, String marca, String modelo, int potencia) {
        if (isMatriculaValida(matricula)) {
            this.matricula = matricula;
        }
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean isMatriculaValida(String matricula) {
        if (matricula.length() != 8 || matricula.charAt(2) != '-' || matricula.charAt(5) != '-') {
            return false;
        }

        int numeros = 0, letras = 0;

        for (int contador = 0; contador < matricula.length(); contador++) {
            if (Character.isLetter(matricula.charAt(contador))) {
                if (matricula.charAt(contador) == (matricula.toUpperCase().charAt(contador))) {
                    ++letras;
                    continue;
                }
            }

            if (Character.isDigit(matricula.charAt(contador))) {
                ++numeros;
            }

            if (contador == 2) {
                if (numeros != 2 && letras != 2) {
                    return false;
                }
            }

            if (contador == 4) {
                if ((numeros != 2 || letras != 2) && (numeros != 4)) {
                    return false;
                }
            }

        }

        if (numeros == 4 && letras == 2) {
            return true;
        }
        return false;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    @Override
    public void trajeto(int quilometros) {
        kmstemp = quilometros;
        kmstotal += quilometros;
    }

    @Override
    public int ultimoTrajeto() {
        return kmstemp;
    }

    public int distanciaTotal() {
        return kmstotal;
    }

    @Override
    public String toString() {
        return "Matrícula: " + this.getMatricula() + "; Marca: " + this.getMarca() + "; Modelo: " + this.getModelo()
                + "; Potência: " + this.getPotencia();
    }
}
