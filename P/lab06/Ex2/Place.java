public class Place {
    private String name;

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Location: " + this.getName();
    }
}
