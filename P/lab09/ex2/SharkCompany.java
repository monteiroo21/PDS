import java.util.List;

public class SharkCompany {
	public static void main(String[] args) {
		Person[] persons = { new Person("Maria Silva"),   
			new Person("Manuel Pereira"),  
			new Person("Aurora Machado"),  
			new Person("Augusto Lima")   }; 
		Facade shark = new Facade(); 
		Company.user = User.OWNER; 
		shark.admitEmployee(persons[0], 1000); 
		shark.admitEmployee(persons[1], 900); 
		shark.admitEmployee(persons[2], 1200); 
		shark.admitEmployee(persons[3], 1100); 
		List<Employee> sharkEmps = shark.employees(); 
		for (Employee e : sharkEmps) 
			System.out.println(e.getSalary()); 
		shark.paySalaries(1); 

		for (Employee e : sharkEmps) {
            e.getBankAccount().withdraw(500);
            System.out.println(e.getBankAccount().balance());
        }

		Parking parking = shark.getParking();
		Insurance insurance = shark.getInsurance();
		SocialSecurity ss = shark.getSS();
		for (Person p : persons) {
			parking.allow(p, sharkEmps);
			insurance.regist(p);
			ss.regist(p);
		}

		System.out.println("-------------------");
		System.out.println("PARKING:");
		for (Person p : persons) {
			System.out.println(p.getName() + ": " + parking.park().contains(p));
		}

		System.out.println("-------------------");
		System.out.println("INSURANCE:");
		for (Person p : persons) {
			System.out.println(p.getName() + ": " + insurance.insurance().contains(p));
		}
		
		System.out.println("-------------------");
		System.out.println("SOCIAL SECURITY:");
		for (Person p : persons) {
			System.out.println(p.getName() + ": " + ss.socialSecurity().contains(p));
		}
	}
}