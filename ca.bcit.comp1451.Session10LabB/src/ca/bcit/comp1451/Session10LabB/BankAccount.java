package ca.bcit.comp1451.Session10LabB;

public class BankAccount {
	String name;
	double balance;
	
	public BankAccount() {//String name, double balance) {
		//super();
		setName(name);
		setBalance(balance);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name != null && name.length() > 1) {
			this.name = name;
		}else {
			this.name = "unknown name";
		}
		
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		if(balance > 0) {
			this.balance = balance;
		} // else { throw new IllegalExceptionArgument("balance can't be negative");
	}
	/**
	 * 
	 * @param amount can't be negative
	 * @throws InsufficientFundException if param is negative
	 */
	public void deposit(double amount) throws NegativeAmountException{
		if(amount > 0) {
				balance = balance + amount;
			}else {	
				throw new NegativeAmountException( amount + ": amount can't be negative");	
			}
		} 

	public void withdraw(double amount) throws InsufficientFundException{
		if(amount > 0 && amount  <= balance) {
			balance = balance - amount;
		}else {
			throw new InsufficientFundException( amount + ": amount can't be negative, nor can it be higher than the balance");
		}
		
	}

	@Override
	public String toString() {
		return getName() + " " + getBalance();
	}

}
