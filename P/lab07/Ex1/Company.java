import java.util.List;
import java.util.ArrayList;

public class Company {
    private Database db;
    private Registos reg;
    public Company(Database db, Registos reg) {
        this.db = db;       // Read&Write
        this.reg = reg;     // Read
    }

    public void addEmployee(EmployeeAdapter emp) {
        if (checkEmployee(emp.getCodigo())) System.out.println("Impossible to add that employee!");
        else db.addEmployee(new Employee(emp.getName(), emp.getCodigo(), emp.getSalary()));

    }

    public void deleteEmployee(long code) {
        db.deleteEmployee(code);
        reg.remove((int) code);
    }

    public boolean checkEmployee(long code) {
        List<EmployeeAdapter> employees = new ArrayList<EmployeeAdapter>();
        for (Empregado emp: reg.listaDeEmpregados()) {
            employees.add(emp.empregadoToEmployee());
        }
        for (Employee emp: db.getAllEmployees()) {
            if (emp.getEmpNum() == code) return true;
        }
        for (EmployeeAdapter emp: employees) {
            if (emp.getCodigo() == code) return true;
        }
        
        return false;
    }

    public void empInfo() {
        List<EmployeeAdapter> employees = new ArrayList<EmployeeAdapter>();
        for (Empregado emp: reg.listaDeEmpregados()) {
            employees.add(emp.empregadoToEmployee());
        }
        for (Employee emp: db.getAllEmployees()) {
            System.out.println("Name: " + emp.getName() + ", Employee number: " + emp.getEmpNum() + ", Salary: " + emp.getSalary());
        }
        for (EmployeeAdapter emp: employees) {
            System.out.println("Name: " + emp.getName() + ", Employee number: " + emp.getCodigo() + ", Salary: " + emp.getSalary());
        }
    }
}
