public class Ex3 {
    public static void main(String[] args) {
        Mediator mediator = new AirControl();
        AirTransports plane = new Plane(mediator, "plane");
        AirTransports helicopter = new Helicopter(mediator, "helicopter");
        AirTransports glider = new Glider(mediator, "glider");

        plane.sendMessage("Hello, I am a plane.");
        helicopter.sendMessage("Hello, I am a helicopter.");
        glider.sendMessage("Hello, I am a glider.");
    }
}
