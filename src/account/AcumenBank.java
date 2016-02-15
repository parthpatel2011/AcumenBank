package account;


import account.CheckingAccount;
import account.SavingsAccount;

public class AcumenBank {

	public static void main(String[] args) {
		System.out.println("Welcome to Acumen Bank!");
		System.out.println();

		CheckingAccount michaelsAccount = new CheckingAccount("Michael", 5000);
		CheckingAccount gobsAccount = new CheckingAccount("Gob", 2000);

		System.out.println("Open Accounts:");
		System.out.println();
		printAccountDetails(michaelsAccount);
		System.out.println();
		printAccountDetails(gobsAccount);

		System.out.println();
		System.out.println("Making transfer of $1000...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			return;
		}

		michaelsAccount.transfer(gobsAccount, 1000);

		System.out.println("Updated Account Details:");
		System.out.println();
		printAccountDetails(michaelsAccount);
		System.out.println();
		printAccountDetails(gobsAccount);

		
		// Initialize new savings account with initial balance of $30,000 and 0.89% interest
		SavingsAccount acesSavingsAccount = new SavingsAccount("Ace", 30000, .0089);
		System.out.println();
		printSavingDetails(acesSavingsAccount);
		
		// Initialize new savings account with initial balance of $10,000 and 0.56% interest
		SavingsAccount garysSavingsAccount = new SavingsAccount("Gary", 10000, .0056);
		System.out.println();
		printSavingDetails(garysSavingsAccount);
		
		System.out.println();
		System.out.println("Making transfer of $5000...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			return;
		}
		
		//Making a transfer from Ace's Account to Gary's Account
		acesSavingsAccount.transfer(garysSavingsAccount, 5000);
		System.out.println();
		printSavingDetails(garysSavingsAccount);

		// apply 2 years of interest to the savings accounts
		acesSavingsAccount.applyInterest(2);
		garysSavingsAccount.applyInterest(2);
		
		System.out.println();
		System.out.println("Updated Account Details:");
		printSavingDetails(acesSavingsAccount);
		System.out.println();
		printSavingDetails(garysSavingsAccount);
		
	}
	
	//print CheckingsAccountInfo
	private static void printAccountDetails(CheckingAccount account) {
		System.out.format("Account for %s:\r\n", account.getOwnerName());
		System.out.format("Balance: $%.2f\r\n", account.getBalance());
	}

	//print SavingsAccountInfo
	private static void printSavingDetails(SavingsAccount account) {
		System.out.format("Savings Account for %s:\r\n", account.getOwnerName());
		System.out.format("Initial Balance: $%.2f\r\n", account.getprincipal());
		System.out.format("Intrest Rate: %2.2f%%\n", account.getannualintrest()*100);
		System.out.format("Balance after 2 years: $%.2f\r\n", account.getSavingBalance());
	}
}
