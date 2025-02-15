public interface Mediator {
    void registerAirTransport(AirTransports airTransport);

    void notifyAirTransports(AirTransports airTransport, String message);
}
