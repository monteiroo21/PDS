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

}
