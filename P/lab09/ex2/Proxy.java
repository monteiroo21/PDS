public class Proxy implements BankAccount {
    BankAccount bankAccount;

	Proxy(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override public void deposit(double amount) {
		this.bankAccount.deposit(amount);
	}

	@Override public boolean withdraw(double amount) {
        if (Company.user == User.OWNER) {
            return this.bankAccount.withdraw(amount);
        }
        return false;
	}
	
	@Override public double balance() {
        if (Company.user == User.OWNER) {
            return this.bankAccount.balance();
        }
		return 0.0;
	}
}
