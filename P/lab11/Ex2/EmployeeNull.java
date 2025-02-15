public class EmployeeNull extends Employee {
    public EmployeeNull() {
        this.name = "Null";
    }

    @Override
    public String getName() {
        return name;
    }
}
