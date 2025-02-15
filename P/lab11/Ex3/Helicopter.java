public class Helicopter extends AirTransports {
    public Helicopter(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Helicopter " + id + " received: " + message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Helicopter " + id + " sends: " + message);
        mediator.notifyAirTransports(this, message);
    }
}
