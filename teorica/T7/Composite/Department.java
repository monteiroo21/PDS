import java.util.List;

public class Department {
    private String name;
    private List<ConcreteEmployee> employees;
    private List<Department> subDepartments;

    public Department(String name, List<ConcreteEmployee> employees, List<Department> subDepartments) {
        this.name=name;
        this.employees=employees;
        this.subDepartments=subDepartments;
    }

    public void showDetails() {
        for (ConcreteEmployee e: this.employees) {
            e.showDetails();
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<ConcreteEmployee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<ConcreteEmployee> employees) {
        this.employees = employees;
    }
    public List<Department> getSubDepartments() {
        return subDepartments;
    }
    public void setSubDepartments(List<Department> subDepartments) {
        this.subDepartments = subDepartments;
    }

    
}
