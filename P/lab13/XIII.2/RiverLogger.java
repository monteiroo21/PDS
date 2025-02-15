import java.util.ArrayList;
import java.util.List;

public class RiverLogger {
    private List<String> log;

    public RiverLogger() {
        log = new ArrayList<>();
    }

    public void log(String message) {
        log.add(message);
    }

    public List<String> getLog() {
        return log;
    }
}
