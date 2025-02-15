// Student authors:
// NMec:  Name:
// 113278 Jorge Domingues
// 114547 João Monteiro

public class Flight {
    private String code;
    private Plane plane;
    private int turistSeats;
    private int executiveSeats;
    private int reservations;

    public Flight(String code, Plane plane) {
        this.code = code;
        this.plane = plane;
        turistSeats = plane.getTourCapacity();
        executiveSeats = plane.getExecCapacity();
        reservations = 0; // first reservation
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int getTuristSeats() {
        return turistSeats;
    }

    public void setTuristSeats(int turistSeats) {
        this.turistSeats = turistSeats;
    }

    public int getExecutiveSeats() {
        return executiveSeats;
    }

    public void setExecutiveSeats(int executiveSeats) {
        this.executiveSeats = executiveSeats;
    }

    public int getReservations() {
        return reservations;
    }

    public void setReservations(int reservations) {
        this.reservations = reservations;
    }

    public boolean canReservation(Classes classes, int numReservations) {
        if (classes == Classes.Tourist) {
            return numReservations <= plane.getTourCapacity() - plane.getTourSeats(); // if there are not enough seats
        } else {
            return numReservations <= plane.getExecCapacity() - plane.getExecSeats();
        }
    }

    public int FirstEmptyRow(Classes classes) {
        int[][] seats = (classes == Classes.Tourist) ? plane.getSeats_T() : plane.getSeats_E();

        int numCol = seats[0].length; // number of columns
        int numRow = seats.length; // number of rows
        int emptyRow = -1; // first empty row

        for (int i = 0; i < numRow; i++) {
            boolean empty = true;
            for (int j = 0; j < numCol; j++) {
                if (seats[i][j] != 0) {
                    empty = false; // if there is a seat reserved, the row is not empty
                    break;
                }
            }
            if (empty) {
                emptyRow = i; // if the row is empty, we save the row number
                break;
            }
        }
        return emptyRow;
    }

    public boolean makeReservation(Classes classes, int numSeats) {

        int[][] seats_E = plane.getSeats_E();
        int[][] seats_T = plane.getSeats_T();
        int numSeatsReserved = 0;

        int emptyRow = FirstEmptyRow(classes);
        int firstLine = emptyRow != -1 ? emptyRow : 0; // if there is an empty row, we start from there, otherwise we
                                                       // start from the first row
        if (classes == Classes.Executive && canReservation(Classes.Executive, numSeats)) {
            reservations++;
            while (true) {
                for (int j = firstLine; j < seats_E.length; j++) {
                    for (int i = 0; i < seats_E[0].length; i++) {
                        if (seats_E[j][i] == 0) {
                            seats_E[j][i] = reservations; // change the seat to indicate it is occupied
                            numSeatsReserved++;

                            if (numSeatsReserved >= numSeats) {
                                return true;
                            }
                        }
                    }
                }

                firstLine = 0; // if we have to start from the first row, we reset the firstLine variable
            }

        } else if (classes == Classes.Tourist && canReservation(Classes.Tourist, numSeats)) {
            reservations++;
            while (true) {
                for (int j = firstLine; j < seats_T.length; j++) {
                    for (int i = 0; i < seats_T[0].length; i++) {
                        if (seats_T[j][i] == 0) {
                            seats_T[j][i] = reservations; // change the seat to indicate it is occupied
                            numSeatsReserved++;

                            if (numSeatsReserved >= numSeats) {
                                return true;
                            }
                        }
                    }
                }
                firstLine = 0; // if we have to start from the first row, we reset the firstLine variable
            }
        } 
        return false;
        
    }

    public void cancelReservation(String reservationCode) {
        int reservation_code = Integer.parseInt(reservationCode);
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
    }

}