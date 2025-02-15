import java.util.ArrayList;
import java.util.List;

public class ShipOfSmallShips implements Ship {
    private List<PassengerShip> ships;
    private String name;
    private String code;

    public ShipOfSmallShips(String code, String name) {
        ships = new ArrayList<PassengerShip>();
        this.code = code;
        this.name = name;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String name() {
        return this.name;
    }

    public void add(PassengerShip ship) {
        ships.add(ship);
    }

    public void remove(PassengerShip ship) {
        System.out.println(ship.name() + " removed");
        ships.remove(ship);
    }

    public int getShips() {
        return ships.size();
    }

    private int getLimit() {
        return this.ships.stream().mapToInt(ship -> {
            return ship.getNumPassengers();
        }).sum();
    }

    @Override
    public String toString() {
        String a = "";
        a += "Ref: " + this.code() + " - Container Ship with " + ships.size() + " ships. Total passengers capacity: " + this.getLimit() + "\n";
        for (Ship ship: ships) {
            a += "\t" + ship.toString() + "\n";
        }
        return a;
    }
}
