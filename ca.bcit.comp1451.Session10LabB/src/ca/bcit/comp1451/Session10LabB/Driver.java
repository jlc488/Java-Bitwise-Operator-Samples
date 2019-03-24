package ca.bcit.comp1451.Session10LabB;

public class Driver {
	public static void main (String[] args) throws NegativeAmountException, InsufficientFundException {
		Bank b1 = new Bank();
		b1.processTransaction();
	}

}
