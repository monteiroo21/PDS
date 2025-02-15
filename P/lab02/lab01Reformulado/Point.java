// Student authors:
// NMec:  Name:
// 113278 Jorge Domingues
// 114547 João Monteiro

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    } 

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Point p) {
        return this.x == p.x && this.y == p.y;
    }  
}
