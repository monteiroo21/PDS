import java.util.List;
import java.util.ArrayList;


public class ChatMediator {
    private List<Colleague> colleagues;  
    
    public ChatMediator() {
        colleagues = new ArrayList<Colleague>();
    }

    public void addColleague(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
        }
    }

    public void sendMessage(int ID) {
        for (Colleague colleague : colleagues) {
            if (ID == colleague.getID()) {
                System.out.println(ID + " sent a message!");
            }
        }

        for (Colleague colleague : colleagues) {
            if (ID != colleague.getID()) {
                colleague.receiveMessage(ID);
            }
        }

    }
}
