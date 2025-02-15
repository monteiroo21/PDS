public class Programmer extends Employee {
    private String name;

    public Programmer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
