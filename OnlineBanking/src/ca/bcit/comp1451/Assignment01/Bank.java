package ca.bcit.comp1451.Assignment01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
	private String bankName;
	private HashMap<String, Account> accounts = null;

	public Bank(String bankName) {
		this.setBankName(bankName);

		this.accounts = new HashMap<String, Account>();
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = this.bankNameValidator(bankName);
	}

	private String bankNameValidator(String bankName) {
		if (bankName == null || "".equals(bankName)) {
			throw new IllegalArgumentException("The Bank name can not be null or empty!");
		}

		return bankName;
	}

	public void addAccount(Account account) {
		if (account != null) {
			this.accounts.put(account.getAccountNumber(), account);
		}
	}

	public Account getAccount(String accountNumber) {
		if (accountNumber == null || "".equals(accountNumber)) {
			throw new IllegalArgumentException("The Account number can not be null or empty!");
		}

		Account tempAccount = this.accounts.get(accountNumber);

		if (tempAccount != null) {
			System.out.println("The Account Number : " + accountNumber);
			tempAccount.getCustomer().displayInformation();
		} else {
			System.out.println("The account number does not exists!");
		}

		return tempAccount;
	}

	public void showTransactions(String name) {
		for (Map.Entry<String, Account> entry : this.accounts.entrySet()) {
			Account temp = entry.getValue();
			Customer tempCustomer = temp.getCustomer();
			if (tempCustomer.getName().equals(name)) {
				temp.displayAccountInfo();
			}
		}
	}

	public void displayAccountNumbers() {
		for (Map.Entry<String, Account> entry : this.accounts.entrySet()) {
			System.out.println("Account Number is : " + entry.getKey());
		}
		System.out.println();
	}

	public void makeTransaction() {
		String yN = "n";
		while (true) {
			System.out.print("Enter the Account Number : ");
			System.out.println();
			Scanner sc = new Scanner(System.in);

			String accountNumber = sc.nextLine();

			Account accnt = this.getAccount(accountNumber);

			if (accnt == null) {
				System.out.println("fuck");
				break;
			} else {
				while (true) {
					System.out.println("1.Deposit");
					System.out.println("2.Withdraw");
					System.out.println("3.Show Transaction");
					System.out.println("Please Enter your choice: ");
					System.out.println();
					String choice = sc.nextLine();

					switch (choice) {
					case "1":

						System.out.println("Enter Deposit Amount : ");
						System.out.println();
						double depositAmount = sc.nextDouble();
						if (accnt.deposit(depositAmount)) {
							System.out.println("Enter Month in number between 1 and 12 : ");
							System.out.println();
							int depositDay = sc.nextInt();
							System.out.println("Enter Day in number between 1 and 31 : ");
							System.out.println();
							int depositMonth = sc.nextInt();
							System.out.println("Enter Current Year in number ex)2019 : ");
							System.out.println();
							int depositYear = sc.nextInt();
							Date dDate = new Date(depositDay, depositMonth, depositYear);
							accnt.addTransaction(new TransactionRecord(depositAmount, dDate, accountNumber, "deposit"));
							System.out.println("Do you wish to continue ? y/n : ");
							System.out.println();
							yN = sc.next();
						}
						break;
					case "2":
						System.out.println("Enter Withdrawal Amount : ");
						System.out.println();
						double withdrawAmount = sc.nextDouble();
						if (accnt.withdraw(withdrawAmount)) {
							System.out.println("Enter Month in number between 1 and 12 : ");
							System.out.println();
							int withDrawDay = sc.nextInt();
							System.out.println("Enter Day in number between 1 and 31 : ");
							System.out.println();
							int withDrawMonth = sc.nextInt();
							System.out.println("Enter Current Year in number ex)2019 : ");
							System.out.println();
							int withDrawYear = sc.nextInt();
							Date wDate = new Date(withDrawDay, withDrawMonth, withDrawYear);
							accnt.addTransaction(
									new TransactionRecord(withdrawAmount, wDate, accountNumber, "withdraw"));
							System.out.println("Do you wish to continue ? y/n : ");
							System.out.println();
							yN = sc.next();
						}
						break;
					case "3":
						System.out.println("Enter User Name : ");

						accnt.transactionDisplay();
						System.out.println("Do you wish to continue ? y/n : ");
						System.out.println();
						yN = sc.next();
						break;
					}
					if ("n".equals(yN)) {
						break;
					}
				}
			} // end of else

			if ("n".equals(yN)) {
				System.out.println("Sayonara~~!!!!!");
				break;
			}
		} // while
	}// makeTransaction
}
