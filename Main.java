import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		File file = new File("Data.txt");
		Scanner scanData = new Scanner(file);
		FileReader fR = new FileReader(file);
		BufferedReader bR = new BufferedReader(fR);
		String line;
		int arrSize = 0;
		int accNum = 0;
		int pin = 0;
		double depositValue = 0;
		double withdrawValue = 0;
		while((line = bR.readLine()) != null) {
			arrSize++;
	}
		List<Accounts> accounts = new ArrayList<Accounts>();
		while (scanData.hasNext()) {
			int accNumBuffer = scanData.nextInt();
			int pinBuffer = scanData.nextInt();
			double balanceBuffer = scanData.nextDouble();
			accounts.add(new Accounts (accNumBuffer, pinBuffer, balanceBuffer));
		}
		
		System.out.println("Welcome!");
		System.out.print("Enter Account Number: ");
		accNum=scan.nextInt();
		int found = -1;
		while(found==-1) {
			for(int i = 0; i<accounts.size();i++)
				if(accounts.get(i).getAccountNum()==accNum)
					found = i;
			if (found != -1)
				break;
			System.out.print("Invalid account number, enter another one: ");
			accNum = scan.nextInt();
		}
		
		boolean pinFlag = false;
		System.out.print("Enter your pin: ");
		pin = scan.nextInt();
		while (!pinFlag) {
			if (accounts.get(found).getPin()==pin) {
				pinFlag=true;
				break;
			}
			System.out.print("Incorrect pin, enter another one: ");
			pin = scan.nextInt();
		}
		
		int option = 0;
		System.out.println("Choose an option:\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
		option = scan.nextInt();
		while(option<1 || option>4) {
			System.out.print("Invalid option, enter another one: ");
			option = scan.nextInt();
		}
		boolean runBuffer = true;
		while(runBuffer) {
			if (option == 4)
				System.exit(0);
			if (option == 1)
				System.out.println("Your balance is: " + accounts.get(found).getBalance());
			if (option == 2 ) {
				System.out.print("Enter deposit value: ");
				depositValue = scan.nextDouble();
				accounts.get(found).deposit(depositValue);
				System.out.println("Your new balance is: " + accounts.get(found).getBalance());
			}
			if (option == 3) {
				System.out.print("Enter withdraw value: ");
				withdrawValue = scan.nextDouble();
				accounts.get(found).withdraw(withdrawValue);
				System.out.println("Your new balance is: " + accounts.get(found).getBalance());
				
			}
			System.out.print("Pick another option: ");
			option = scan.nextInt();
			while(option<1 || option>4) {
				System.out.print("Invalid option, enter another one: ");
				option = scan.nextInt();
			}
		}	
	}
	
}
