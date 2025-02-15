

public class Voo {
    private Aviao aviao;
    
    private String id;

    public Voo(Aviao aviao,String id){
        this.aviao = aviao;
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public Aviao getAviao() {
        return aviao;
    }
    public void printVoo(){
        int linhas = aviao.getClasseExec().length + aviao.getClasseTur().length;

        // Imprimir cabeçalho com números de assentos
        System.out.print("  ");
        for (int i = 1; i <= linhas; i++) {
            System.out.print(String.format("%2d ", i));
        }
        System.out.println();

        int colunas;
        char nomeColuna = 'A';
        if(aviao.getClasseExec()[0].length > aviao.getClasseTur()[0].length){
            colunas = aviao.getClasseExec()[0].length;
        }else{
            colunas = aviao.getClasseTur()[0].length;
        }
        

        for (int i = 0; i < colunas; i++) {

            System.out.print(nomeColuna + " ");
            if (i < aviao.getClasseExec().length - 1 ){
                for (int j = 0; j < aviao.getClasseExec().length; j++){
                    System.out.print(String.format("%2d ", aviao.getClasseExec()[j][i]));
                }
            }else{
                for (int j = 0; j < aviao.getClasseExec().length; j++){
                    System.out.print("   ");
                }
            }

            if(i < aviao.getClasseTur().length - 1){
                for (int j = 0; j < aviao.getClasseTur().length; j++){
                    System.out.print(String.format("%2d ", aviao.getClasseTur()[j][i]));
                }
            }else{
                for (int j = 0; j < aviao.getClasseTur().length; j++){
                    System.out.print("   ");
                }
            }

            System.out.println();
            nomeColuna++;
        }

        System.out.println("");

    }
}
