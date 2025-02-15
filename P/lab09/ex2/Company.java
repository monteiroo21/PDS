import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Company {
	public static User user;
	private List<Employee> emps = new ArrayList<>();

	public void admitEmployee(Person person, double salary) {
		Employee emp = new Employee(person.getName(), salary);
		emps.add(emp);
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}
