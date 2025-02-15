public class mediumState implements State {
    @Override
    public void pull(CeilingFan fan) {
        fan.setState(new highState());
    }

    @Override
    public String getName() {
        return "Medium";
    }
}
