public class WordData {
    private String word;
    private int x;
    private int y;
    private String direction;
    private Integer size;

    // Constructor
    public WordData(String word) {
        this.word = word;
        this.size = word.length();
    }
    // Getters
    public String getWord() {
        return word;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public Integer getSize() {
        return size;
    }

    // Setters
    public void setWord(String word) {
        this.word = word;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    public void printData() {
        String formattedOutput = String.format("%-20s %3d %4d,%-5d %s", word.toLowerCase(), x, y, size, direction);
        System.out.println(formattedOutput);
    }
    
}
