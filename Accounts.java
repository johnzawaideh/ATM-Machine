public class Accounts {
	private int accountName;
	private int password;
	private double balance;
	
	public Accounts(int account_Name, int pass, double balance) {
		accountName = account_Name;
		password = pass;
		this.balance = balance;
	}
	
	public int getAccountName() {
		return accountName;
	}
	
	public int getPassword() {
		return password;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	}

