public class CeilingFan {
    private State state;

    public CeilingFan() {
        state = new offState();
    }

    public void pull() {
        state.pull(this);
    }

    public String getState() {
        return state.getName();
    }

    public void setState(State state) {
        this.state = state;
    }
}
