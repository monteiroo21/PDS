public class offState implements State {
    @Override
    public void pull(CeilingFan fan) {
        fan.setState(new lowState());
    }

    @Override
    public String getName() {
        return "Off";
    }
}
