
public class Aviao {
    private int lExec; //TOTAL LUGARES exec
    private int lTuris;  //total lugares turismo
    private int lugaresExecDisponiveis;
    private int lugaresTuristasDisponiveis;
    private int linhasExec;
    private int colunasExec;
    private int linhasTuris;
    private int colunasTuris;
    private String [] dadosExec;
    private String [] dadosTuris;
    private int [] [] disposicaoExec; //TABULEIRO DE LUGARES DE EXEC
    private int [] [] disposicaoTuris; //TABULEIRO DE LUGARES TURISMO
    private  int id=0;

    private Aviao(String dadosTuris,String dadosExec ){
        this.dadosTuris=dadosTuris.split("x");
        this.lTuris=Integer.parseInt(this.dadosTuris[0])*Integer.parseInt(this.dadosTuris[1]);
        this.disposicaoTuris=new int [Integer.parseInt(this.dadosTuris[0])] [Integer.parseInt(this.dadosTuris[1])];
        this.dadosExec=dadosExec.split("x");
        this.lExec=Integer.parseInt(this.dadosExec[0])*Integer.parseInt(this.dadosExec[1]);
        this.disposicaoExec=new int [Integer.parseInt(this.dadosExec[0])] [Integer.parseInt(this.dadosExec[1])];
        this.lugaresTuristasDisponiveis=this.lTuris;
        this.lugaresExecDisponiveis=this.lExec;
        this.linhasExec=Integer.parseInt(this.dadosExec[0]);
        this.colunasExec=Integer.parseInt(this.dadosExec[1]);
        this.linhasTuris=Integer.parseInt(this.dadosTuris[0]);
        this.colunasTuris=Integer.parseInt(this.dadosTuris[1]);
    }

    public static Aviao criarAviao(String dadosTuris,String dadosExec){
        return new Aviao(dadosTuris,dadosExec);
    }

    private Aviao(String dadosTuris){
        this.dadosTuris=dadosTuris.split("x");
        this.lExec=0;
        this.lTuris=Integer.parseInt(this.dadosTuris[0])*Integer.parseInt(this.dadosTuris[1]);
        this.disposicaoTuris=new int [Integer.parseInt(this.dadosTuris[0])] [Integer.parseInt(this.dadosTuris[1])];
        this.lugaresTuristasDisponiveis=this.lTuris;
        this.lugaresExecDisponiveis=this.lExec;
        this.linhasExec=0;
        this.colunasExec=0;
        this.linhasTuris=Integer.parseInt(this.dadosTuris[0]);
        this.colunasTuris=Integer.parseInt(this.dadosTuris[1]);
    }

    public static Aviao criarAviao(String dadosTuris){
        return new Aviao(dadosTuris);
    }

    

    public int getLExec() {
        return this.lExec;
    }

    public int getLTuris() {
        return this.lTuris;
    }
    //implementação de M
    public void printAviao(){
        int linhasTuristas=Integer.parseInt(this.dadosTuris[0]);
        int colunasTuristas=Integer.parseInt(this.dadosTuris[1]);
        if(this.lExec>0){
            int linhasExecutivas=Integer.parseInt(this.dadosExec[0]);
            int colunasExecutivas=Integer.parseInt(this.dadosExec[1]);
            int maxColunas;
            if(colunasExecutivas>= colunasTuristas){
                maxColunas=colunasExecutivas;
            }
            else{
                maxColunas=colunasTuristas;
            }
            System.out.print(" ");
            for (int i= 0; i<linhasExecutivas ;i++){
                System.out.printf("%3s ",i+1);
            }
            for (int a= linhasExecutivas; a<linhasTuristas+ linhasExecutivas;a++){
                System.out.printf("%3s ",a+1);
            }
            System.out.println("");
    
            int valorInicial =65; // CORRESPONDE AO A em ascii
            char classe;
            int j;
            int espaco=0;
            for (int k =0;k<maxColunas;k++){
                classe=(char) valorInicial;
                System.out.print(classe);
                // vamos verificar se primeiro existem lugares de executivo
                if (this.lTuris !=0){
                    for ( j=0;j<linhasExecutivas;j++){
                        if (k < colunasExecutivas){
                            System.out.printf("%3s ",this.disposicaoExec[j][k]);
                        }
                        
                    }
                     espaco=j;
                }
                String s=" ";
                if (k >=colunasExecutivas){  
                    for(int b=0;b<linhasExecutivas;b++) {
                        System.out.printf("%3s ",s);  
                    }   
                }
                for (j=0;j<linhasTuristas;j++){
                    if (k < colunasTuristas){
                       
                        System.out.printf("%3s ",this.disposicaoTuris[j][k]);
                        
                    }
                    
                }
                valorInicial++;
                System.out.println("");
    
            }
        }
        else{
            System.out.print(" ");
            for (int a= 0; a<linhasTuristas;a++){
                System.out.printf("%3s ",a+1);
            }
            System.out.println("");
            int valorInicial =65; // CORRESPONDE AO A em ascii
            char classe;
            int j;
            for (int k =0;k<colunasTuristas;k++){
                classe=(char) valorInicial;
                System.out.print(classe);
                // vamos verificar se primeiro existem lugares de executivo
                for (j=0;j<linhasTuristas;j++){
                    if (k < colunasTuristas){
                        System.out.printf("%3s ",this.disposicaoTuris[j][k]);
                    }
                    
                }
                valorInicial++;
                System.out.println("");
            }
        }

        
      }

    public String reservaLugares( char tipo, int lugares ){
        int i,j;
        String retorno="";
        int valorInicial =65; // CORRESPONDE AO A em ascii
        char classe;
        boolean check=true;
        int linha,coluna,coluna2;
        switch (tipo){
            case 'E':
            

                    if(lugares > this.lugaresExecDisponiveis){
                        System.out.printf("Não foi possivel obter lugares para a reserva: %s %d\n",tipo,lugares);
                        return " ";
                    }
                     int  linhasExecutivas=Integer.parseInt(this.dadosExec[0]);
                    int colunasExecutivas=Integer.parseInt(this.dadosExec[1]);
                    
                    this.id++;
                    retorno+=id;
                    retorno+=" ";
                    for ( linha=0; linha <linhasExecutivas;linha++){
                        check=true;
                        for ( coluna=0; coluna<colunasExecutivas;coluna++){
                            if(this.disposicaoExec[linha][coluna] != 0){
                                check=false;
                                
                                break;
                                
                            }
                        }
                        if (check){
                        for (coluna2=0; coluna2<colunasExecutivas;coluna2++){
                            if(this.disposicaoExec[linha][coluna2] == 0){
                                this.disposicaoExec[linha][coluna2]=this.id;
                                lugares--;
                                this.lugaresExecDisponiveis--;
                                classe=(char)(valorInicial+coluna2);
                                retorno+=linha+1;
                                retorno+=classe;
                                retorno+= " | ";
                                if (lugares ==0){
                                    return retorno;
                                }
                                
                            }
                        }
                     }
                    }
                    for(i=0;i<linhasExecutivas;i++){
                        for (j=0;j<colunasExecutivas;j++){
                            if (this.disposicaoExec[i][j] == 0){
                                this.disposicaoExec[i][j]=this.id;
                                lugares--;
                                this.lugaresExecDisponiveis--;
                                this.lugaresExecDisponiveis--;
                                classe=(char)(valorInicial+colunasExecutivas);
                                retorno+=linha+1;
                                retorno+=classe;
                                retorno+= " | ";
                                if (lugares ==0){
                                    return retorno ;
                                }
                            }
                        }
                    }
                
                    break;
            case 'T':

                    if(lugares > this.lugaresTuristasDisponiveis){
                        System.out.printf("Não foi possivel obter lugares para a reserva: %s %d\n",tipo,lugares);
                        return " ";
                    }
                    int linhasTuristas=Integer.parseInt(this.dadosTuris[0]);
                    int colunasTuristas=Integer.parseInt(this.dadosTuris[1]);
                    this.id++;
                    retorno+=id;
                    retorno+=" ";


                    //tentar colocar em um fila vazia primeiro tudo de seguida e se não der para colocar tudo nesta meter na proxima
                    //
                    for ( linha=0; linha <linhasTuristas;linha++){
                        check=true;
                            for ( coluna=0; coluna<colunasTuristas;coluna++){
                                if(this.disposicaoTuris[linha][coluna] != 0){
                                    check=false;
                                    break;
                                    
                                }
                            }
                            if (check){
                            
                            for ( coluna2=0; coluna2<colunasTuristas;coluna2++){
                                if(this.disposicaoTuris[linha][coluna2] == 0){
                                    this.disposicaoTuris[linha][coluna2]=this.id;
                                    lugares--;
                                    this.lugaresTuristasDisponiveis--;
                                    classe=(char)(valorInicial+coluna2);
                                    
                                    retorno+=linha+1+this.linhasExec;
                                    retorno+=classe;
                                    retorno+= " | ";
                                    if (lugares ==0){
                                        return retorno;
                                    }
                                    
                                }
                            }
                    }
                }
                    for(i=0;i<linhasTuristas;i++){
                        for (j=0;j<colunasTuristas;j++){
                            if (this.disposicaoTuris[i][j] == 0){
                                this.disposicaoTuris[i][j]=this.id;
                                lugares--;
                                this.lugaresTuristasDisponiveis--;
                                classe=(char)(valorInicial+colunasTuristas);
                                retorno+=linha+1+this.linhasExec;
                                retorno+=classe;
                                retorno+= " | ";
                                if (lugares ==0){
                                    return retorno;
                                }
                            }
                        }
                    }
                    
                    break;
            default:
                    System.out.println("NÃO EXISTE ESSE TIPO DE PASSAGEIRO");
                    return " ";
        }
        return " ";
    }
    public void deleteReserva(int numero){
        boolean aviso=false;
            for (int i =0;i< this.linhasExec;i++){
                for(int j=0;j<this.colunasExec;j++){
                    if(numero== this.disposicaoExec[i][j]){
                        this.disposicaoExec[i][j]=0;
                        
                        aviso=true;
                    }
                }
            }
            for (int i =0;i< this.linhasTuris;i++){
                for(int j=0;j<this.colunasTuris;j++){
                    if(numero== this.disposicaoTuris[i][j]){
                        this.disposicaoTuris[i][j]=0;
                        aviso=true;
                    }
                }
            }

        if (!aviso){
            System.out.println(" O sequential_reservation_number não possui nenhum reserva");
        }
        else{
            System.out.println("RESERVA ELIMINADA");
        }

    }

    @Override
    public String toString() {
        return "{" +
            " lExec='" + getLExec() + "'" +
            ", lTuris='" + getLTuris() + "'" +
            "}";
    }
    


}