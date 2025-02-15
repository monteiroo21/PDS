// Student authors:
// NMec:  Name:
// 113278 Jorge Domingues
// 114547 João Monteiro

public class Plane {
    private int[][] seats_T; // turist class seats
    private int[][] seats_E; // executive class seats

    public Plane(int[][] seats_T, int[][] seats_E) {
        this.seats_T = seats_T;
        this.seats_E = seats_E;
    }

    public int[][] getSeats_T() {
        return seats_T;
    }

    public void setSeats_T(int[][] seats_T) {
        this.seats_T = seats_T;
    }

    public int[][] getSeats_E() {
        return seats_E;
    }

    public void setSeats_E(int[][] seats_E) {
        this.seats_E = seats_E;
    }

    public int getTourCapacity() {
        if (seats_T.length == 0) {
            return 0;
        }
        return seats_T[0].length * seats_T.length;
    }

    public int getExecCapacity() {
        if (seats_E.length == 0) {
            return 0;
        }
        return seats_E[0].length * seats_E.length;
    }

    public int getTourSeats() { // occupied seats for turist class
        int count = 0;
        for (int i = 0; i < seats_T.length; i++) {
            for (int j = 0; j < seats_T[i].length; j++) {
                if (seats_T[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getExecSeats() { // occupied seats for executive class
        if (seats_E.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < seats_E.length; i++) {
            for (int j = 0; j < seats_E[i].length; j++) {
                if (seats_E[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
