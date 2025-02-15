public class Retangle {
    private int height;
    private int width;

    public Retangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void accept(Visitor visitor) {
        visitor.visitRetangle(this);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
