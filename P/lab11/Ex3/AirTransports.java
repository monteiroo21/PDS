public abstract class AirTransports {
    protected Mediator mediator; // Mediator is a reference to the mediator object
    protected String id;

    public AirTransports(Mediator mediator, String id) {
        this.mediator = mediator;
        this.id = id;
        mediator.registerAirTransport(this);
    }

    public abstract void receiveMessage(String message);

    public abstract void sendMessage(String message);

}
