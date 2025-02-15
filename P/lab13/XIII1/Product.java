import java.util.List;

public interface Product {
	String code();
	String description();
	double points();
	void addObserver(Client client);
	List<Client> getObservers();
}
