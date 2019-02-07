package ca.bcit.comp1451.Assignment01;

public class TransactionRecord {
	private double amount;
	private Date date;
	private String accountNumber;
	private String transactionType; //withdraw or deposit
	
	
	
	public TransactionRecord(double amount, Date date, String accountNumber, String transactionType){
		this.setAmount(amount);
		this.setDate(date);
		this.setAccountNumber(accountNumber);
		this.setTransactionType(transactionType);
		
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = this.amountValidator(amount);
	}
	
	private double amountValidator(double amount) {
		
		if(amount >= 0) {
			return amount;
		}else {
			throw new IllegalArgumentException("amount can't be negative");
		}
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date) {
		this.date = this.dateValidator(date);
	}
	
	private Date dateValidator(Date date) {
		if(date != null) {
			return date;
		}else {
			throw new IllegalArgumentException("date can't be null");
		}
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = this.accountNumberValidator(accountNumber);
	}
	
	private String accountNumberValidator(String accountNumber) {
		if(accountNumber == null || "".equals(accountNumber)) {
			throw new IllegalArgumentException("Account number can't be null or empty");
		}
		
		return accountNumber;
	}
	
	public String getTransactionType () {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = this.transactionTypeValidator(transactionType);
	}
	
	private String transactionTypeValidator(String transactionType) {
		if(!transactionType.equalsIgnoreCase("withdraw") && !transactionType.equalsIgnoreCase("deposit")) {
			throw new IllegalArgumentException("transaction type must be withdraw or deposit only");
		}
		
		return transactionType;
	}

	//a method that returns a String that contains the acct#, type of transaction, amount and date
	public String displayTransaction() {
		String transactionInfo = " Account Number:" + this.getAccountNumber() + " Transaction Type:" + this.getTransactionType() + 
				" Amount:" + this.getAmount() + " Date:" + this.getDate().formatDate();
		return transactionInfo;
	}
}
