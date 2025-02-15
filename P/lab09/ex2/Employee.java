class Employee {
	private double salary;
	private String name;
	private BankAccount bankAccount;
	
	public Employee(String n, double s) {
		this.name = n;
		this.salary = s;
		this.bankAccount = new BankAccountImpl("PeDeMeia", 0);
	}

	public double getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
		return new Proxy(bankAccount);
	}
}