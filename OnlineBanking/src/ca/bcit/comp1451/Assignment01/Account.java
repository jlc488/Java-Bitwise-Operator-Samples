package ca.bcit.comp1451.Assignment01;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private Customer customer;
	private String accountNumber;
	private Date dateAccountCreated;
	private double balance;
	static int uniqueNum = 1000;
	
	private List<TransactionRecord> arrayList = null;
	
	public Account(Customer customer, Date dateAccountCreated, double balance) {
		this.setCustomer(customer);
		this.setAccountNumber(this.makeAccountNum());
		this.setDateAccountCreated(dateAccountCreated);
		this.setBalance(balance);
		
		arrayList = new ArrayList<>();
		
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getDateAccountCreated() {
		return dateAccountCreated;
	}

	public void setDateAccountCreated(Date dateAccountCreated) {
		this.dateAccountCreated = dateAccountCreated;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	//a private method to create an account num and assign it to the field accountNumber.
	// each account obj should have a unique account num. create a static var set it to value 1000
	// incrementic the static var in the priv method. assign the result to the field account number.
	//dont forget to call the priv method in the constructor
	private String makeAccountNum() {
		return uniqueNum+++"";
	}
	
	public boolean  deposit(double amount) {
		boolean done = false;
		
		if(amount > 0.0) {
			this.setBalance(balance + amount);
			done = true;
		}else {
			System.out.println("the amount was invalid");
		}
		
		return done;
	}
	
	public boolean withdraw(double amount) {
		boolean done = false;
		
		if(amount > 0 || amount <= this.getBalance()) {
			this.setBalance(this.getBalance() - amount);
			done = true;
		}else {
			System.out.println("the amount was invalid");
		}
		
		return done;
	}
	
	//a method to add a transaction to the arraylist
	public void addTransaction(TransactionRecord tr) {
		this.arrayList.add(tr);
	}
	
	//a method that iterates thorugh the transactionRecord collection and displays it's info in an organized manner
	public void transactionDisplay() {
		for (TransactionRecord tr : arrayList) {
			System.out.println("Account Number: " + tr.getAccountNumber());
			System.out.println("Transaction Type: " + tr.getTransactionType());
			System.out.println("The Amount : " + tr.getAmount());
			System.out.println("Date : " + tr.getDate().formatDate());
			System.out.println();
		}
	}
	
	// display customer fullname, accountNumber, balance, date the account was created
	public void displayAccountInfo() {
		System.out.println("Full Name : " + this.getCustomer().formatName(this.getCustomer().getName()));
		System.out.println("Account Number : " + this.getAccountNumber());
		System.out.println("The Balance : " + this.getBalance());
		System.out.println("The date the account created : " + this.getDateAccountCreated().formatDate());
	}
	
	
}
