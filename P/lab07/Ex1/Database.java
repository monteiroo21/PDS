import java.util.Vector;

public class Database {
    private Vector<Employee> employees; // Stores the employees 
 
    public Database() { 
        employees = new Vector<>(); 
    } 

    public boolean addEmployee(Employee employee) { 
        return employees.add(employee);
    } 

    public void deleteEmployee(long emp_num) { 
        Employee empToRemove = null;
        for (Employee emp: employees) {
            if (emp.getEmpNum() == emp_num) {
                empToRemove = emp;
            }
        }
        employees.remove(empToRemove);
    } 
    
    public Employee[] getAllEmployees() { 
        int size = employees.size();
        Employee[] emps = new Employee[size];
        int idx = 0;
        for (Employee emp: employees) {
            emps[idx] = emp;
            idx++;
        }
        return emps;
    }    
}
