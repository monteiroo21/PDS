import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EmployeeInterface employee = new Employee("António Silva");

        employee.start(new Date());
        employee.work();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TeamMember tm1 = new TeamMember(employee);
        tm1.start(new Date());
        tm1.work();
        tm1.colaborate();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tm1.terminate(new Date());

        EmployeeInterface employee2 = new Employee("Maria Silva");
        TeamMember tm = new TeamMember(employee2);
        tm.start(new Date());
        tm.work();
        tm.colaborate();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tm.terminate(new Date());

        EmployeeInterface employee3 = new Employee("João Silva");
        TeamLeader tl = new TeamLeader(employee3);
        tl.start(new Date());
        tl.work();
        tl.plan();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tl.terminate(new Date());

        EmployeeInterface employee4 = new Employee("Manuel Silva");
        Manager m = new Manager(employee4);
        m.start(new Date());
        m.work();
        m.manage();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        m.terminate(new Date());
    }
}
