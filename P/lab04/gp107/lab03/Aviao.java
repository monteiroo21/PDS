

public class Aviao {
    private int[][] classeTur;  
    private int[][] classeExec;    
    private int nSequencial = 1;

    public Aviao(){

    }

    public Aviao(int comprimentoTur, int larguraTur, int comprimentoExec, int larguraExec){
        this.classeTur = new int[comprimentoTur][larguraTur];
        this.classeExec = new int[comprimentoExec][larguraExec];
        
    }

    public Aviao(int comprimentoTur, int larguraTur){
        this.classeTur = new int[comprimentoTur][larguraTur];
        this.classeExec = new int[0][0];
    }

    public int[][] getClasseTur() {
        return classeTur;
    }

    public int[][] getClasseExec() {
        return classeExec;
    }

    public int firstEmptyLine(char classe){
        if(classe == 'E'){
            for (int i = 0; i < classeExec.length; i++){
                if(classeExec[i][0] == 0){
                    return i;
                }
            }
        }else if(classe == 'T'){
            for (int i = 0; i < classeTur.length; i++){
                 if(classeTur[i][0] == 0){
                    return i;
                 }
            }
        }else{
            System.err.println("caracter invalido: " + classe);
            System.exit(1);
        }

        return -1;
         
    }
    public int firstEmptySeatOnLine(char classe, int line){
        if(classe == 'E'){
            for(int i = 0; i < classeExec[line].length; i++){
                if(classeExec[line][i] == 0){
                    return i;
                }
            }
        }else if(classe == 'T'){
            for(int i = 0; i < classeTur[line].length; i++){
                if(classeTur[line][i] == 0){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean enoughSeatsForReservation(char classe, int numOfSeats){
        int counter = 0;
        if(classe == 'E'){
            for(int i = 0; i < classeExec.length; i++){
                for(int j = 0; j < classeExec[i].length; j++){
                    if(classeExec[i][j] == 0){
                        counter++;
                    }
                }
            }
        }else{
            for(int i = 0; i < classeTur.length; i++){
                for(int j = 0; j < classeTur[i].length; j++){
                    if(classeTur[i][j] == 0){
                        counter++;
                    }
                }
            }
        }
        return (counter >= numOfSeats);
    }

    public void addReservation(char classe, int numOfSeats){

        if(!enoughSeatsForReservation(classe,numOfSeats)){
            System.out.println("Não foi possível obter lugares para a reserva: " + classe + " " + numOfSeats);
            return;
        }
        if(classe == 'E'){
            int available = firstEmptyLine(classe);
            if(available != -1){
                int contador = 0;
                for (int i = available; i < classeExec.length; i++) {
                    for (int j = 0; j < classeExec[i].length; j++) {
                        if (contador < numOfSeats) {
                            classeExec[i][j] = nSequencial;
                            contador++;
                        }
                        
                    }
                }
            }else{
                int contador = 0;
                for (int i = 0; i < classeExec.length; i++){
                    if(firstEmptySeatOnLine(classe,i) != -1){
                        int availableSeat = firstEmptySeatOnLine(classe,i);
                        if (contador < numOfSeats){
                            classeExec[i][availableSeat] = nSequencial;
                            contador++;
                        }

                    }
                }
            }

        }else if(classe == 'T'){
            int available = firstEmptyLine(classe);
            if(available != -1){
                int contador = 0;
                for (int i = available; i < classeTur.length; i++) {
                    for (int j = 0; j < classeTur[i].length; j++) {
                        if (contador < numOfSeats) {
                            classeTur[i][j] = nSequencial;
                            contador++;
                        }
                        
                    }
                }

            }else{
                int contador = 0;
                for (int i = 0; i < classeTur.length; i++){
                    if(firstEmptySeatOnLine(classe,i) != -1){
                        int availableSeat = firstEmptySeatOnLine(classe,i);
                        if (contador < numOfSeats){
                            classeTur[i][availableSeat] = nSequencial;
                            contador++;
                        }

                    }else{
                        break;
                    }
                }
            }
        }else{
            System.err.println("caracter invalido: " + classe);
            System.exit(1);
        }
        nSequencial++;

    }

    
}
