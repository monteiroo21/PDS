public class Colleague {
    private ChatMediator mediator = new ChatMediator();
    private static int next_ID = 1;
    private int ID;

    public Colleague(ChatMediator mediator) {
        this.mediator = mediator;
        this.ID = next_ID;
        next_ID++;
    }

    public void sendMessage() {
        mediator.sendMessage(ID);
    }

    public void receiveMessage(int ID) {
        System.out.println("Received message from " + ID);
    }

    public int getID() {
        return this.ID;
    }
}
