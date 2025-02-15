public class highState implements State {
    @Override
    public void pull(CeilingFan fan) {
        fan.setState(new offState());
    }

    @Override
    public String getName() {
        return "High";
    }
}
