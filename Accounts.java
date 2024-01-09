public class Accounts {

	
	private int accNum;
	private int pin;
	private double balance;
	
	public Accounts(int accountNum, int pin, double balance) {
	accNum = accountNum;
	this.pin = pin;
	this.balance = balance;
}
	
	int getAccountNum() {
		return accNum;
	}
	
	int getPin() {
		return pin;
	}
	
	double getBalance() {
		return balance;
	}
	
	void deposit(double amount) {
		balance += amount;
	}
	
	void withdraw(double amount) {
		balance -= amount;
	}
}