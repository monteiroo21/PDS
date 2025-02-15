public class Plane extends AirTransports {
    public Plane(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Plane " + id + " received: " + message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Plane " + id + " sends: " + message);
        mediator.notifyAirTransports(this, message);
    }
}
