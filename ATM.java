import java.util.*;
public class ATM extends Accounts{
	
	public ATM(int account_Name, int pass, double balance) {
		super(account_Name, pass, balance);
	}
	
	public static void main(String args[]) {
		

		Scanner scan = new Scanner(System.in);
		Accounts account1 = new Accounts(98372947, 4366, 983534);
		Accounts account2 = new Accounts(38792743, 9264, 9872);
		Accounts account3 = new Accounts(93759175, 8520, 713532);
	
		HashMap<Integer, Integer> accounts = new HashMap<Integer, Integer>();
		accounts.put(account1.getAccountName(), account1.getPassword());
		accounts.put(account2.getAccountName(), account2.getPassword());
		accounts.put(account3.getAccountName(), account3.getPassword());
		
		boolean accountNumFlag = false;
		
		System.out.print("Enter Account Number: ");
		int accountNum = scan.nextInt();
		while (!accountNumFlag) {
			
			if (accounts.containsKey(accountNum)) {
				accountNumFlag = true;
				break;
			}
			System.out.print("Incorrect account number, please enter another one: ");
			accountNum = scan.nextInt();
		}
			
		boolean passwordFlag = false;
		
		System.out.print("Enter Account Password: ");
		int accountPass = scan.nextInt();
		
		while (!passwordFlag) {
			if (accounts.get(accountNum) == accountPass) {
				passwordFlag = true;
				break;
			}
			System.out.print("Incorrect Password, please try again: ");
			accountPass = scan.nextInt(); 
		}
		int option;
		
		//used to keep on running the ATM in case user wants to use another option
		boolean run = true;
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
		System.out.print("Choose an option: ");
		option = scan.nextInt();
		
		double depositValue, withdrawValue;
		
		while (run) {
			
			if (option == 1) {
				if(accountNum == account1.getAccountName())
					System.out.println("Your account balance is: " + account1.getBalance());
				else if (accountNum == account2.getAccountName())
					System.out.println("Your account balance is: " + account2.getBalance());
				else System.out.println("Your account balance is: " + account3.getBalance());
			}
			else if (option == 2) {
				System.out.print("Enter the amount you would like to deposit: ");
				depositValue = scan.nextDouble();
				if(accountNum == account1.getAccountName()) {
					account1.deposit(depositValue);
					System.out.println("Your balance is now " + account1.getBalance());
				}
				else if (accountNum == account2.getAccountName()) {
					account2.deposit(depositValue);
					System.out.println("Your balance is now " + account2.getBalance());
				}
				else {
					account3.deposit(depositValue);
					System.out.println("Your balance is now " + account3.getBalance());
				}
			}
			else if (option == 3) {
				System.out.print("Enter the amount you would like to withdraw: ");
				withdrawValue = scan.nextDouble();
				if(accountNum == account1.getAccountName()) {
					account1.withdraw(withdrawValue);
					System.out.println("Your balance is now " + account1.getBalance());
				}
				else if (accountNum == account2.getAccountName()) {
					account2.withdraw(withdrawValue);
					System.out.println("Your balance is now " + account2.getBalance());	
				}
				else  {
					account3.withdraw(withdrawValue);
					System.out.println("Your balance is now " + account3.getBalance());
				}
			}
			else if (option == 4) {
				System.out.println("Thank you for using the ATM");
				break;
			}
			else {
				System.out.println("Invalid option, please enter another one: ");
				option = scan.nextInt();
				continue;
			}
			System.out.print("Enter another option: ");
			option = scan.nextInt();
		}
	scan.close();	
		}
}
