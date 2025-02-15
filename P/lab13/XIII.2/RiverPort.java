import java.util.Iterator;

public class RiverPort implements Port {
    private SeaPort seaPort;
    private RiverLogger riverLogger;

    public RiverPort() {
        this.seaPort = new SeaPort();
        this.riverLogger = new RiverLogger();
    }

    @Override
    public boolean add(String ref, Ship p) {
        if (p instanceof PassengerShip) {
            if (((PassengerShip)p).getNumPassengers()> 10) {
                return false;
            }
        }
        if (p instanceof CargoShip) {
            if (((CargoShip)p).getLoad()> 10) {
                return false;
            }
        }
        riverLogger.log("Added");
        return seaPort.add(ref, p);
    }

    @Override
    public boolean exists(String ref) {
        if (seaPort.exists(ref)) {
            riverLogger.log("exists");
        }
        return seaPort.exists(ref);
    }

    @Override
    public Ship remove(String ref) {
        riverLogger.log("remove");
        return seaPort.remove(ref);
    }

    @Override
    public Iterator<String> iterator() {
        return seaPort.iterator();
    }
}
