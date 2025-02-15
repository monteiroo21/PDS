import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class SeaPort implements Port {
    private Map<String, Ship> harbor;

    public SeaPort() {
        harbor = new HashMap<String , Ship>();
    }

    @Override
    public Iterator<String> iterator() {
        return harbor.entrySet().stream().map(ship -> {
            return "Ref: " + ship.getKey() + " - " + ship.getValue();
        }).iterator();

    }

    @Override
    public boolean add(String ref, Ship p) {
        if (harbor.get(ref) == null) {
            harbor.put(ref, p);
            return true;
        }
        return false;
    }

    @Override
    public boolean exists(String ref) {
        return (harbor.get(ref) != null);
    }

    @Override
    public Ship remove(String ref) {
        if (harbor.get(ref) != null) {
            Ship s = harbor.get(ref);
            harbor.remove(ref);
            return s;
        }
        return null;
    }
    
}
