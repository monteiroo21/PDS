public class lowState implements State {
    @Override
    public void pull(CeilingFan fan) {
        fan.setState(new mediumState());
    }

    @Override
    public String getName() {
        return "Low";
    }
}
