public class Glider extends AirTransports {
    public Glider(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Glider " + id + " received: " + message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Glider " + id + " sends: " + message);
        mediator.notifyAirTransports(this, message);
    }
}
