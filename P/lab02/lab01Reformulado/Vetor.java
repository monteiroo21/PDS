// Student authors:
// NMec:  Name:
// 113278 Jorge Domingues
// 114547 João Monteiro

public class Vetor {
    private Orientations orientation;
    private Point point;
    private int length;

    public Vetor(Orientations orientation, Point point, int length) {
        this.orientation = orientation;
        this.point = point;
        this.length = length;
    }

    public Orientations getOrientation() {
        return orientation;
    }

    public Point getPoint() {
        return point;
    }

    public int getLength() {
        return length;
    }

    public void setOrientation(Orientations orientation) {
        this.orientation = orientation;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String toString() {
        return "Vetor [orientation=" + orientation + ", point=" + point + ", length=" + length + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vetor other = (Vetor) obj;
        if (length != other.length) {
            return false;
        }
        if (orientation != other.orientation) {
            return false;
        }
        if (point == null) {
            if (other.point != null) {
                return false;
            }
        } else if (!point.equals(other.point)) {
            return false;
        }
        return true;
    }

}
