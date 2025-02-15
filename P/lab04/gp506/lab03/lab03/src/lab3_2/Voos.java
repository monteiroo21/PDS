
import java.util.Map;
import java.util.TreeMap;
public class Voos {
    private Map<Voo,Aviao> conjuntoVoo;

    private Voos(){
        this.conjuntoVoo= new TreeMap<Voo,Aviao>();
    }

    public static Voos criarVoos(){
        return  new Voos();
    }
    
    public void adicionarVoo(String code,String dadosTuris,String dadosExec){
        if (dadosTuris.contains("x") && dadosExec.contains("x")){
            String[] partida = dadosTuris.split("x");
            String[] partida1 = dadosExec.split("x");
            try {
                Integer.parseInt(partida[0]);
                Integer.parseInt(partida[1]);
                Integer.parseInt(partida1[0]);
                Integer.parseInt(partida1[1]);
            } catch (Exception e) {
                System.out.println("Impossivel construi objetos dados invalidos\n Tenta linhaxcoluna");
                return;
            }
        }
        else{
            System.out.println("Impossivel construi objetos dados invalidos\n Tenta linhaxcoluna");
            return;
        }
        Voo a=Voo.criarVoo(code);
        Aviao avi=Aviao.criarAviao(dadosTuris,dadosExec);
        this.conjuntoVoo.put(a, avi);
    }
    public void adicionarVoo(String code,String dadosTuris){
        if (dadosTuris.contains("x")){
            String[] partida = dadosTuris.split("x");
            try {
                Integer.parseInt(partida[0]);
                Integer.parseInt(partida[1]);
            } catch (Exception e) {
                System.out.println("Impossivel construi objetos dados invalidos\nTenta linhaxcoluna");
                return;
            }
        }
        else{
            System.out.println("Impossivel construi objetos dados invalidos\nTenta linhaxcoluna");
            return;
        }
        Voo a=Voo.criarVoo(code);
        Aviao avi=Aviao.criarAviao(dadosTuris);
        this.conjuntoVoo.put(a, avi);
    }
    public void infoVoo(String code){
        for (Voo a : this.conjuntoVoo.keySet()) {
            if (a.getCode().equals(code)){
                Aviao av=this.conjuntoVoo.get(a);
             
                System.out.printf("Código de voo %s. ",code);
                if (av.getLExec() == 0){
                    System.out.print("Classe executiva não disponivel neste voo. ");
                }
                else{
                    System.out.printf("Lugares disponiveis: %d  em classe Executiva. ",av.getLExec());
                }
                System.out.printf("Lugares disponiveis: %d  em classe Turistica. ",av.getLTuris());
            }
            
        }
        System.out.println("");
    }

    public void showAviao(String code){
        boolean controlo=false;
        for (Voo a : this.conjuntoVoo.keySet()) {
            if (a.getCode().equals(code)){
                controlo=true;
                Aviao av=this.conjuntoVoo.get(a);
                av.printAviao();
            }   
        }
        if (!controlo){
            System.out.println("ESTE CÓDIGO INTRODUZIDO NÃO SE ENCONTRA REGISTADO");
        }
    }

    public void reserva(String code, char tipo, int lugares,boolean codigo ){
        boolean controlo=false;
        String compravativo=code;
        compravativo+=":";
        if (tipo == 'T' ){
            controlo=true;
        }
        else if (tipo == 'E' ){
            controlo=true;
        }
        if (!controlo){
            System.out.println("INSIRA TIPO DE PASSAGEIROS VALIDO (T OU E)");
            return ;
        }
        boolean existe=false;
        for (Voo a : this.conjuntoVoo.keySet()) {
            if (a.getCode().equals(code)){
              
                Aviao av=this.conjuntoVoo.get(a);
                compravativo+=av.reservaLugares(  tipo,  lugares );
                if (codigo ){
                    System.out.println(compravativo);
                }
                existe=true;
                
            }   
        }
        if(!existe){
            System.out.println("VOO não existe ");
        }
    }

    public void apagarReserva(String codigoVoo, int pessoa){
        boolean existe=false;
        for (Voo a : this.conjuntoVoo.keySet()) {
            if (a.getCode().equals(codigoVoo)){
              
                Aviao av=this.conjuntoVoo.get(a);
                av.deleteReserva(pessoa);
                existe=true;
                
            }   
        }
        if(!existe){
            System.out.println("VOO não existe ");
        }
    }
}