
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc=null;
        if (args.length==0){
             sc= new Scanner(System.in);
        }
        else{
            File file = new File(args[0]);
            try{
                 sc= new Scanner(file);
            }
            catch(FileNotFoundException e){
                System.err.println("Ficheiro nao encontrado");
                System.exit(0);
            }
        }
            char escolha;
            String argumento="";
            boolean fim=false;
            String [] separar;
            Voos listaVoos=Voos.criarVoos();
            while(true){
                System.out.println("Escolha uma opção: (H para ajuda)");
                escolha=sc.next().charAt(0);
                escolha=Character.toUpperCase(escolha);
                switch (escolha){
                    case 'Q':
                                fim=true;
                                break;
                    case 'H':
                                printMenu();
                                break;
                    case 'I':
                                argumento=sc.nextLine().strip();
                                if(argumento.equals("") ){
                                        System.out.println("Deve inserir um argumento após o I ");
                                        break;
                                }
                                File filename = new File(argumento);
                                Scanner sc2=null;
                                try{
                                         sc2= new Scanner(filename);
                                }
                                catch(FileNotFoundException e){
                                        System.err.println("Ficheiro nao encontrado");
                                        break;
                                }
                                boolean controlo=false;
                                String linha;
                                
                                String dados []; 
                                int contador=0;
                                String code="";
                                char tipo;
                                String [] array;
                                while(sc2.hasNextLine()){
                                        linha =sc2.nextLine();
                                        if(!controlo){
                                                if (linha.charAt(0)!= '>'){
                                                        System.err.println("O primeiro caracter deve ser >");
                                                        break;
                                                }
                                                else{
                                                        separar=linha.split(">");
                                                        dados=separar[1].split(" "); 
                                                        code=dados[0];
                                                }
                                                if(dados.length==3){
                                                        listaVoos.adicionarVoo(dados[0], dados[2],dados[1]);
                                                        listaVoos.infoVoo(dados[0]);
                                                }
                                                else{   
                                                        listaVoos.adicionarVoo(dados[0], dados[1]);     
                                                        listaVoos.infoVoo(dados[0]);
                                                }
                                                controlo=true;
                                                // caso o tamanho dos dados seja 3 significa que não há executive
                                        }
                                        // a cima temos codigo para a primeira linha do file
                                        else{
                                                array=linha.split(" ");
                                                
                                                tipo=array[0].toUpperCase().charAt(0);
                                                try{
                                                        int adicionar=Integer.parseInt(array[1]);
                                                }
                                                catch (Exception e){
                                                        System.out.println("ERRO TEM QUE SER UM INTEIRO O ULTIMO ARGUMENTO");
                                                        break;
                                                }
                                               
                                                listaVoos.reserva(code,tipo,Integer.parseInt(array[1]),false);
                                        }
                                }
                                sc2.close();
                                break;
                    case 'M':
                                argumento=sc.nextLine().strip();
                                if(argumento.equals("") ){
                                        System.out.println("Deve inserir um argumento após o M ");
                                        break;
                                }
                                listaVoos.showAviao(argumento);
                                break;
                    case 'F':
                                argumento = sc.nextLine();
                                separar = argumento.split(" ");
                                if (separar.length==4){
                                        listaVoos.adicionarVoo(separar[1], separar[3], separar[2]);
                                        break;
                                }
                                else if (separar.length==3){
                                        listaVoos.adicionarVoo(separar[1], separar[2]);
                                        break;
                                }
                                else{
                                        System.out.println("Argumento inválido após o F");
                                        break;
                                }
                        
                    case 'R':
                                argumento = sc.nextLine();
                                separar = argumento.split(" ");
                                if (separar.length==4){
                                        try {
                                                int vagas=Integer.parseInt(separar[3]);
                                                listaVoos.reserva(separar[1],separar[2].toUpperCase().charAt(0),vagas,true);
                                            } catch (Exception e) {
                                                System.out.println("Segundo argumento e deverá ser um T/E,o ultimo valor deve ser um inteiro ");
                                                return;
                                            }
                                        break;
                                }
                                else{
                                        System.out.println("Deve introduzir um codigo de voo class (T/E) e quantos lugares ");
                                        break;
                                }
                                
                                
                    case 'C':
                                argumento = sc.nextLine();
                                separar = argumento.split(":");
                                if (separar.length==2){
                                        
                                        String codigoVoo=separar[0].strip();
                                        try {
                                                int pessoa=Integer.parseInt(separar[1]);
                                                listaVoos.apagarReserva(codigoVoo,pessoa);
                                            } catch (Exception e) {
                                                System.out.println("Erro ao tentar passar o sequential_reservation_number para inteiro ");
                                                return;
                                            }
                                        break;
                                }
                                else{
                                        System.out.println("Deve introduzir a string com o formato flight_code:sequential_reservation_number");
                                } 
                                break;
                    default:
                                System.out.println("Opção não implementada, pressione a tecla H se precisa de ajuda");
                }
                if (fim){
                    break;
                }
            
            }

            sc.close();
    }

    public static void printMenu(){
            System.out.println("I filename -> ler um ficheiro de texto que tem informações sobre um voo");
            System.out.println("M flight_code -> exibe o mapa de voo de um avião ");
            System.out.println("F flight_code num_seats_executive  num_seats_tourist -> Acrescenta um novo voo o arguemento de executives é opcional");
            System.out.println("R flight_code class number_seats -> Acrescenta uma nova reserva a um voo, classe tem de ser T/E");
            System.out.println("C reservation_code -> Cancela uma reserva, formato flight_code:sequential_reservation_number");
            System.out.println("Q -> QUIT");
    }
}
