import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jeep implements Product {
    private String code;
    private String description;
    private double points;
    private List<Client> observers;

    public Jeep(OldJeep jeep) {
        String data = jeep.getData();
        String regex = "([^;]+);([^;]+);([^;]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        if (matcher.matches()) {
            this.code = matcher.group(1);
            this.description = matcher.group(2);
            this.points = Double.parseDouble(matcher.group(3));
        } else {
            throw new IllegalArgumentException("Data format is incorrect: " + data);
        }

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
        return "Jeep: code=" + code + ", description=" + description + ", points=" + points;
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
