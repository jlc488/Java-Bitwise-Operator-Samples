package ca.bcit.comp1451.Session10LabB;

import java.util.Scanner;

public class Bank { // extends BankAccount {
	Scanner scanner;
	BankAccount account;
	
	public Bank() {
		//BankAccount bankAccount1; // = new BankAccount("acct1", 0);
		setAccount(account);
		scanner = new Scanner(System.in);
		
	}
	public Scanner getScanner() {
		return scanner;
	}
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	public BankAccount getAccount() {
		return account;
	}
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	public void processTransaction() throws NegativeAmountException, InsufficientFundException {
		String yN = "y";
		int choice;
		double amount;
		BankAccount bankAccount1 = new BankAccount();
		while(yN != "n") {
			System.out.println("Choose the transaction type by selecting the number:");
			System.out.println("1. deposit");
			System.out.println("2. withdraw");
			System.out.println("3. Display information");
			choice = scanner.nextInt();
				if(choice == 1) {
					//deposit
					System.out.println("enter amount to deposit: ");
					try {
						amount = scanner.nextDouble();
						bankAccount1.deposit(amount);
					}catch(NegativeAmountException exc) {
						System.out.println(exc.getMessage());
					}
					System.out.println ("Would you like to do another transaction?: y /n ?");
					yN = scanner.next();
					if(yN.equals("n")) {
						System.out.println("GoodBye.");
						break;
					}
				}else if(choice == 2) {
					//withdraw
					System.out.println("enter amount to withdraw: ");
					try {
						amount = scanner.nextDouble();
						bankAccount1.withdraw(amount);
					} catch(InsufficientFundException exc) {
						System.out.println(exc.getMessage());
					}
					System.out.println ("Would you like to do another transaction?: y /n ?");
					yN = scanner.next();
					if(yN.equals("n")) {
						System.out.println("GoodBye.");
						break;
					}
				}else if(choice == 3) {
					//display information
					//toString();
					System.out.println(bankAccount1.getBalance());
					System.out.println ("Would you like to do another transaction?: y /n ?");
					yN = scanner.next();
					if(yN.equals("n")) {
						System.out.println("GoodBye.");
						break;
					}
				}// end of choice 3
		}//end while main yN loop
	}// end method processTransaction	

} // end class Bank
