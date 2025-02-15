public class Card {
    private int ID;
    private String name;
    private static int nextID = 1;

    public Card(String name) {
        this.ID = nextID;
        this.name = name;
        nextID++;
    }
}
