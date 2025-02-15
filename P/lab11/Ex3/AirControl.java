import java.util.ArrayList;
import java.util.List;

public class AirControl implements Mediator {
    private List<AirTransports> airTransports;

    public AirControl() {
        airTransports = new ArrayList<>();
    }

    public void registerAirTransport(AirTransports airTransport) {
        airTransports.add(airTransport);
    }

    public void notifyAirTransports(AirTransports airTransport, String message) {
        for (AirTransports at : airTransports) {
            if (!at.equals(airTransport)) {
                at.receiveMessage(message); // Send message to all other air transports
            }
        }
    }
}
