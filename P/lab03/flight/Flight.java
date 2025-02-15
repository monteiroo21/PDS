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
        int[][] seats = null;

        if (classes == Classes.Tourist) {
            if (numReservations > plane.getTourCapacity() - plane.getTourSeats()) { // if there are not enough seats
                return false;
            } else {
                seats = plane.getSeats_T();
            }
        } else {
            if (numReservations > plane.getExecCapacity() - plane.getExecSeats()) {
                return false;
            } else {
                seats = plane.getSeats_E();
            }
        }

        int numCol = seats[0].length; // number of columns
        int numRow = seats.length; // number of rows
        int reservate = 0; // number of reservations made
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

        boolean canReserve = false; // if we can make the reservation
        if (emptyRow != -1) {
            for (int i = emptyRow; i < numRow && !canReserve; i++) {
                for (int j = 0; j < numCol && !canReserve; j++) {
                    if (seats[i][j] == 0) {
                        seats[i][j] = this.reservations;
                        reservate++; // we made a reservation
                    }

                    if (reservate == numReservations) {
                        canReserve = true; // if we made all the reservations, we can reserve
                    }
                }
            }
            if (reservate < numReservations) {
                for (int i = 0; i < emptyRow && !canReserve; i++) {
                    for (int j = 0; j < numCol && !canReserve; j++) {
                        if (seats[i][j] == 0) {
                            seats[i][j] = this.reservations;
                            reservate++;
                        }

                        if (reservate == numReservations) {
                            canReserve = true;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < numRow && !canReserve; i++) {
                for (int j = 0; j < numCol && !canReserve; j++) {
                    if (seats[i][j] == 0) {
                        seats[i][j] = this.reservations;
                        reservate++;
                    }

                    if (reservations == numReservations) {
                        canReserve = true;
                    }
                }
            }
        }

        if (canReserve) {
            this.reservations++; // we made a reservation
            if (classes == Classes.Tourist) { // we update the number of seats
                plane.setSeats_T(seats);
            } else {
                plane.setSeats_E(seats);
            }
            return true; // we can make the reservation
        } else {
            return false; // we can't make the reservation
        }
    }
}