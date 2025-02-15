import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ConcreteEmployee emp1 = new ConcreteEmployee("João", "Developer");
        ConcreteEmployee emp2 = new ConcreteEmployee("José", "Manager");
        List<ConcreteEmployee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);

        ConcreteEmployee emp3 = new ConcreteEmployee("Maria", "Developer");
        ConcreteEmployee emp4 = new ConcreteEmployee("Raquel", "Manager");
        List<ConcreteEmployee> employees1 = new ArrayList<>();
        employees.add(emp3);
        employees.add(emp4);

        Department dep1 = new Department("DETI", employees, null);
        Department dep2 = new Department("SKY", employees1, null);
        List<Department> subDepartments = new ArrayList<>();
        subDepartments.add(dep1);
        subDepartments.add(dep2);

        Department dep3 = new Department("Aveiro", employees, subDepartments);

        dep3.showDetails();
    }
}
