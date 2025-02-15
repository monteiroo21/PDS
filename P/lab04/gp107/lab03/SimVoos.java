
import java.util.*;
import java.io.*;

public class SimVoos {

    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        Map<String,Voo> voos = new TreeMap<String,Voo>();
        while (true) {
            System.out.print("> ");
            String[] input = scanner.nextLine().split("\\s+");

            switch (input[0]) {
                case "H":
                    printMenu();
                    break;
                case "Q":
                    System.exit(1);
                    break;
                case "I":
                    try {
                        File file = new File(input[1]);
                        Scanner fileScanner = new Scanner(file);
                        String firstFileLine = fileScanner.nextLine();
                        String[] vooInfo = firstFileLine.split("\\s+");
                        Aviao aviao = new Aviao();
            
                        if(vooInfo.length == 3){
                            String[] dimensaoExec = vooInfo[1].split("x");
                            String[] dimensaoTur = vooInfo[2].split("x");
                            aviao = new Aviao(Integer.parseInt(dimensaoTur[0]),Integer.parseInt(dimensaoTur[1]),Integer.parseInt(dimensaoExec[0]),Integer.parseInt(dimensaoExec[1]));
                        }else if(vooInfo.length == 2){
                            String[] dimensaoTur = vooInfo[1].split("x");
                            aviao = new Aviao(Integer.parseInt(dimensaoTur[0]),Integer.parseInt(dimensaoTur[1]));
                        }else{
                            System.err.println("");
                        }                        
                        
                        while (fileScanner.hasNextLine()) {
                            String[] reservation = fileScanner.nextLine().split("\\s+");
                            
                            aviao.addReservation(reservation[0].charAt(0),Integer.parseInt(reservation[1]));
                        }
                        Voo voo = new Voo(aviao,vooInfo[0].substring(1));
                        voos.put(voo.getId(), voo);
                        
                        int nclasseExecSeats = voo.getAviao().getClasseExec()[0].length * voo.getAviao().getClasseExec().length;
                        int nclasseTurSeats = voo.getAviao().getClasseTur()[0].length * voo.getAviao().getClasseTur().length;
                        System.out.println("Código de voo "+  voo.getId() + ". Lugares disponíveis: " + nclasseExecSeats + " lugares em classe executiva; " + nclasseTurSeats + " lugares em classe Turística; ");
            
                    }catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");       
                    }

                    break;
                
                case "M":  
                    voos.get(input[1]).printVoo();
                    break;
                default:
                    System.out.println("Opcao invalida");
                    printMenu();
                    break;
            }
            

            

        }
        
        
        

    }
    public static void printMenu(){
        System.out.println("Escolha uma opcao: ");
        System.out.println("H                                                         -> Apresenta as opcoes do menu.");
        System.out.println("I <filename>                                              -> Le um ficheiro de texto contento informacao sobre um voo.");
        System.out.println("M <flight_code>                                           -> Exibir mapa de reservas do Voo.");
        System.out.println("F <flight_code> <num_seats_executive> <num_seats_tourist> -> acrescenta um novo voo, com codigo, lugares em executiva e lugares em turistica");
        System.out.println("R <flight_code> <class> <number_seats>                    -> Acrescenta uma nova reserva a um voo.");
        System.out.println("C <reservation_code>                                      -> Cancela uma reserva.");
        System.out.println("Q                                                         -> Termina o programa."); 
        System.out.println("");
        
    }
    
    
}