import java.util.ArrayList;
import java.util.List;

public class Van implements Product {
    private String code;
    private String description;
    private double points;
    private List<Client> observers;

    public Van(String code, String description, double points) {
        this.code = code;
        this.description = description;
        this.points = points;
        observers = new ArrayList<Client>();
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public double points() {
        return this.points;
    }

    @Override
    public String toString() {
        return "Van: code=" + code + ", description=" + description + ", points=" + points;
    }

    @Override
    public void addObserver(Client client) {
        observers.add(client);
    }

    @Override
    public List<Client> getObservers() {
        return observers;
    }
}
