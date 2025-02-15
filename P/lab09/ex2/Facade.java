import java.util.ArrayList;
import java.util.List;

public class Facade {
    private Company company;
    private SocialSecurity socialSecurity;
    private Insurance insurance;
    private List<Card> cards;
    private Parking parking;

    public Facade() {
        company = new Company();
        socialSecurity = new SocialSecurity();
        insurance = new Insurance();
        cards = new ArrayList<Card>();
        parking = new Parking();
    }

    public void admitEmployee(Person person, double salary) {
        this.company.admitEmployee(person, salary);
        this.socialSecurity.regist(person);
        this.insurance.regist(person);
        Card card = new Card(person.getName());
        cards.add(card);
        this.parking.allow(person, this.company.employees());
    }

    public void paySalaries(int month) {
		this.company.paySalaries(month);
	}
	
	public List<Employee> employees() {
		return this.company.employees();
	}

    public Parking getParking() {
        return parking;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public SocialSecurity getSS() {
        return socialSecurity;
    }
}
