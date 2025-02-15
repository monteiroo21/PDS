// Student authors:
// NMec:  Name:
// 113278 Jorge Domingues
// 114547 João Monteiro

import java.util.*;
import java.io.*;

// int numRows = array.length;
// int numColumns = array[0].length;

public class flightCreate {
    private static char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' }; // letters to use on the map
    static HashMap<String, Flight> flights = new HashMap<String, Flight>();

    public static void main(String[] args) {

        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            String[] input;
            do {
                System.out.println("Escolha uma opção: (H para ajuda) ");
                input = sc.nextLine().split(" ");
                processingTerminal(input);
            } while (!input[0].toUpperCase().equals("Q"));

            System.out.println("Exiting the program...");

            sc.close();

        } else if (args.length == 1) {
            try {
                File file = new File(args[0]);
                if (!file.exists()) {
                    System.err.println("ERROR! The file does not exist!");
                    System.exit(1);
                }
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    processingTerminal(sc.nextLine().split(" "));
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.err.println("File not found!");
                System.exit(1);
            }
        } else {
            System.err.println("ERROR! Could not process the arguments correctly!");
            System.exit(1);
        }
    }

    public static void processingTerminal(String[] line) {
        String opt = line[0].toUpperCase();
        switch (opt) {
            case "H":
                printMenu();
                break;
            case "I":
                if (line.length != 2) {
                    System.err.println("ERROR! Could not process the arguments correctly!\nUsage: I filename");
                    System.exit(1);
                }
                readFile(line[1]);
                break;
            case "M":
                if (line.length != 2) {
                    System.err.println("ERROR! Could not process the arguments correctly!\nUsage: M flight_code");
                    System.exit(1);
                }
                showMap(line[1]);
                break;
            case "F":
                if (line.length != 4 && line.length != 3) {
                    System.err.println(
                            "ERROR! Could not process the arguments correctly!\nUsage: F light_code num_seats_executive num_seats_tourist");
                    System.exit(1);
                }
                if (line.length == 4) {
                    newFlight(line[1], line[2], line[3]);
                } else {
                    newFlight(line[1], null, line[3]); // in case there is no executive seats
                }
                break;
            case "R":
                if (line.length != 4) {
                    System.err.println(
                            "ERROR! Could not process the arguments correctly!\nUsage: R flight_code class number_seats");
                    System.exit(1);
                }
                makeReservation(line[1], line[2], Integer.parseInt(line[3]));
                break;
            case "C":
                if (line.length != 2) {
                    System.err.println("ERROR! Could not process the arguments correctly!\nUsage: C reservation_code");
                    System.exit(1);
                }
                cancelReservation(line[1]);
                break;
            case "Q":
                break;
            default:
                System.err.println("ERROR! Invalid command... (H-I-M-F-R-C-Q)");
                System.exit(1);
        }
    }

    public static void printMenu() {
        System.out.println("H -> opções do menu\n" +
                "I filename -> Ler ficheiro de texto c/ info sobre voo\n" +
                "M flight_code -> exibe mapa das reservas de um voo\n" +
                "F flight_code num_seats_executive num_seats_tourist -> acrescenta um novo voo\n" +
                "R flight_code class number_seats -> acrescenta uma reserva a um voo\n" +
                "C reservation_code -> cancela uma reserva\n" +
                "Q -> termina o programa\n");
    }

    public static void newFlight(String code, String exec, String tour) {
        int[][] exec_seats = null;
        if (exec != null) {
            exec_seats = new int[Integer.parseInt(exec.split("x")[0])][Integer.parseInt(exec.split("x")[1])];
        }
        int[][] tour_seats = new int[Integer.parseInt(tour.split("x")[0])][Integer.parseInt(tour.split("x")[1])];
        Plane plane = new Plane(tour_seats, exec_seats);
        Flight flight = new Flight(code, plane);
        flights.put(code, flight);
    }

    public static void readFile(String fname) {
        int[][] numSeatsTour = null;
        int[][] numSeatsExec = null;
        String flightCode = "";
        String NotReserved = "";

        try {
            File file = new File(fname);
            if (!file.exists()) { // check if the file exists
                System.err.println("ERROR! The file does not exist!");
                System.exit(1);
            }
            boolean isFirstLine = true;
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) { // read the file
                String[] line = sc.nextLine().split(" "); // split the line
                if (isFirstLine) {
                    if (line[0].charAt(0) != '>' || line.length < 2 || line.length > 3) { // check if the first line is
                                                                                          // correct
                        System.err.println("ERROR! Could not process the arguments correctly!");
                        System.exit(1);
                    }

                    flightCode = line[0].substring(1); // get the flight code

                    if (line.length == 3) { // check if the plane has executive seats
                        numSeatsExec = new int[Integer.parseInt(line[1].substring(0, line[1].indexOf("x")))][Integer
                                .parseInt(line[1].substring(line[1].indexOf("x") + 1))];

                        numSeatsTour = new int[Integer.parseInt(line[2].substring(0, line[2].indexOf("x")))][Integer
                                .parseInt(line[2].substring(line[2].indexOf("x") + 1))];
                    } else { // if the plane does not have executive seats
                        numSeatsExec = new int[0][0];
                        numSeatsTour = new int[Integer.parseInt(line[1].substring(0, line[1].indexOf("x")))][Integer
                                .parseInt(line[1].substring(line[1].indexOf("x") + 1))];
                    }

                    Plane plane = new Plane(numSeatsTour, numSeatsExec); // create the plane

                    Flight flight = new Flight(flightCode, plane); // create the flight
                    flights.put(flightCode, flight); // add the flight to the hashmap
                    isFirstLine = false;
                } else { // for the case that we can't make a reservation

                    Flight flight = flights.get(flightCode); // get the flight
                    if (line[0].startsWith("E")) { // check if the reservation is for the executive class
                        if (flight.getExecutiveSeats() == 0) {
                            NotReserved += " " + line[0] + " " + line[1];
                        } else {
                            if (!flight.canReservation(Classes.Executive, Integer.parseInt(line[1]))) {
                                NotReserved += " " + line[0] + " " + line[1];
                            }
                        }
                    } else if (line[0].startsWith("T")) { // check if the reservation is for the tourist class
                        if (flight.getTuristSeats() == 0) {
                            NotReserved += " " + line[0] + " " + line[1];
                        } else {
                            if (!flight.canReservation(Classes.Tourist, Integer.parseInt(line[1]))) {
                                NotReserved += " " + line[0] + " " + line[1];
                            }
                        }
                    }
                }
            }

            if (numSeatsExec.length == 0) { // print the number of available seats
                System.out.println("Código de voo " + flightCode + ". Lugares disponiveis: "
                        + numSeatsTour.length * numSeatsTour[0].length + " em classe Turística.");
                if (NotReserved.length() > 0) {
                    System.out.println("Não foi possível fazer as seguintes reservas: " + NotReserved);
                }
            } else {
                System.out.println("Código de voo " + flightCode + ". Lugares disponiveis: "
                        + (numSeatsTour.length * numSeatsTour[0].length)
                        + " em classe Turística e " + numSeatsExec.length * numSeatsExec[0].length
                        + " em classe Executiva.");
                if (NotReserved.length() > 0) {
                    System.out.println("Não foi possível fazer as seguintes reservas: " + NotReserved);
                }
            }

            sc.close();
        } catch (FileNotFoundException e) { // catch the exception
            System.err.println("File not found!");
            System.exit(1);
        }
    }

    public static void makeReservation(String code, String flightClassString, int numSeats) {
        if (!flightClassString.equals("T") && !flightClassString.equals("E")) {
            System.err.println("ERROR! Inexistent class! E or T");
            System.exit(1);
        }

        if (flights.containsKey(code)) {
            Flight flight = flights.get(code);
            Plane plane = flight.getPlane();
            int[][] seats_E = plane.getSeats_E();
            int[][] seats_T = plane.getSeats_T();
            int numReservations = flight.getReservations(); // to get the number of the current reservation
            int numSeatsReserved = 0;
    
            if (flightClassString.equals("E") && flight.canReservation(Classes.Executive, numSeats)) {
                numReservations++;
                for (int i = 0; i < seats_E[0].length && numSeatsReserved < numSeats; i++) {
                    for (int j = 0; j < seats_E.length && numSeatsReserved < numSeats; j++) {
                        if (seats_E[j][i] == 0) {
                            seats_E[j][i] = numReservations; // change the seat to indicate it is occupied
                            numSeatsReserved++;
                        }
                    }
                }
                flight.setReservations(numReservations);
            } else if (flightClassString.equals("T") && flight.canReservation(Classes.Tourist, numSeats)) {
                numReservations++;
                for (int i = 0; i < seats_T[0].length && numSeatsReserved < numSeats; i++) {
                    for (int j = 0; j < seats_T.length && numSeatsReserved < numSeats; j++) {
                        if (seats_T[j][i] == 0) {
                            seats_T[j][i] = numReservations; // change the seat to indicate it is occupied
                            numSeatsReserved++;
                        }
                    }
                }
                flight.setReservations(numReservations); // setting the new number of reservations
            } else {
                System.err.println("It was impossible to make a reservation!");
                System.exit(1);
            }
        } else {
            System.err.println("ERROR! Impossible to make a reservation to this flight once it does not exist!");
            System.exit(1);
        }
    }

    public static void cancelReservation(String input) {
        String[] parts = input.split(":");
        String flight_code = parts[0];
        int reservation_code = Integer.parseInt(parts[1]);
        if (flights.containsKey(flight_code)) {
            Flight flight = flights.get(flight_code);
            Plane plane = flight.getPlane();
            int[][] seats_E = plane.getSeats_E();
            int[][] seats_T = plane.getSeats_T();
            for (int i = 0; i < seats_E.length; i++) {
                for (int j = 0; j < seats_E[0].length; j++) {
                    if (seats_E[i][j] == reservation_code) {
                        seats_E[i][j] = 0; // define the number of the seat to 0, indicating availability
                    }
                }
            }
            for (int i = 0; i < seats_T.length; i++) {
                for (int j = 0; j < seats_T[0].length; j++) {
                    if (seats_T[i][j] == reservation_code) {
                        seats_T[i][j] = 0;
                    }
                }
            }
            plane.setSeats_E(seats_E); // setting the values
            plane.setSeats_T(seats_T);
            flight.setPlane(plane);
        } else {
            System.err.println("ERROR! Impossible to cancel the reservation for this flight once it does not exist!");
            System.exit(1);
        }
    }

    public static void showMap(String code) {
        int total_col = 0;
        int total_rows = 0;
        if (flights.containsKey(code)) {
            Flight flight = flights.get(code);
            Plane plane = flight.getPlane();
            int[][] seats_E = plane.getSeats_E();
            int[][] seats_T = plane.getSeats_T();
            total_rows = seats_T[0].length;

            if (seats_E.length != 0) {
                if (seats_E[0].length > seats_T[0].length) {
                    total_rows = seats_E[0].length;
                }
                total_col = seats_E.length + seats_T.length;
                System.out.print("\t" + "  ");
                for (int i = 0; i < total_col; i++) {
                    int num = i + 1;
                    System.out.print(num + " ");
                }
                System.out.println();
                for (int i = 0; i < total_rows; i++) {
                    System.out.print("\t" + letters[i] + " ");
                    for (int j = 0; j < total_col; j++) {
                        if (j < seats_E.length) {
                            if (i < seats_E[0].length) {
                                System.out.printf(seats_E[j][i] + " ");
                            } else {
                                System.out.print("  ");
                            }
                        } else {
                            System.out.print(seats_T[j - seats_E.length][i] + " ");
                        }
                    }
                    System.out.println();
                }
            } else {
                total_col = seats_E.length + seats_T.length;
                System.out.print("\t" + "  ");
                for (int i = 0; i < total_col; i++) {
                    int num = i + 1;
                    System.out.print(num + " ");
                }
                System.out.println();
                for (int i = 0; i < total_rows; i++) {
                    System.out.print("\t" + letters[i] + " ");
                    for (int j = 0; j < total_col; j++) {

                        System.out.print(seats_T[j][i] + " ");

                    }
                    System.out.println();
                }
            }

        } else {
            System.err.println("ERROR! Impossible to show the info for this plane once it does not exist!");
            System.exit(1);
        }
    }

}