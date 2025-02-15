public class ConcreteEmployee implements Employee {
    private String name;
    private String position;

    public ConcreteEmployee(String name, String position) {
        this.name=name;
        this.position=position;
    }

    public void showDetails() {
        System.out.println("Name: " + name + ", Position: " + position);
    }
}