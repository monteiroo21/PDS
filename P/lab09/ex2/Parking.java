import java.util.List;
import java.util.ArrayList;

public class Parking {
    List<Person> canPark;

    public Parking() {
        canPark = new ArrayList<Person>();
    }

    public void allow(Person person, List<Employee> employees) {
        int total = 0;
        for (Employee emp : employees) {
            total += emp.getSalary();
        }

        int avg = total / employees.size();

        for (Employee emp : employees) {
            if (emp.getName().equals(person.getName())) {
                if (emp.getSalary() > avg) {
                    canPark.add(person);
                }
            }
        }
    }

    public List<Person> park() {
        return canPark;
    }
}
