package ca.bcit.comp1451.Assignment01;

public class Driver {

	
	public static void main(String[] args) {
		Customer c1 = new Customer("Frank", "Canada", "1972/01/01");
		Customer c2 = new Customer("Ham", "Canada", "1972/11/11");
		Customer c3 = new Customer("Kang", "Korea", "1978/07/08");
		Customer c4 = new Customer("Sin", "Singapore", "1978/12/12");
		
		Bank bank = new Bank("RBC");
		
		Date d1 = new Date(1, 1, 2019);
		Date d2 = new Date(1, 2, 2018);
		Date d3 = new Date(1, 3, 2018);
		Date d4 = new Date(1, 4, 2018);

		Account a1 = new Account(c1, d1, 100);
		Account a2 = new Account(c2, d2, 200);
		Account a3 = new Account(c3, d3, 300);
		Account a4 = new Account(c4, d4, 400);
		
	
		bank.addAccount(a4);
		bank.addAccount(a3);
		bank.addAccount(a2);
		bank.addAccount(a1);
		
		bank.displayAccountNumbers();
		
		bank.makeTransaction();
	}
}
