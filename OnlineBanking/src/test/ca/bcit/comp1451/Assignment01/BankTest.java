package test.ca.bcit.comp1451.Assignment01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.bcit.comp1451.Assignment01.Account;
import ca.bcit.comp1451.Assignment01.Bank;
import ca.bcit.comp1451.Assignment01.Customer;
import ca.bcit.comp1451.Assignment01.Date;
import ca.bcit.comp1451.Assignment01.TransactionRecord;

class BankTest {

	Bank bb = null;
	
	@BeforeEach
	void prepTest() {
		bb = new Bank("RBC");
	}
	@Test
	void testBank() {
		assertNotNull(bb);
	}

	@Test
	void testGetBankName() {
		assertEquals("RBC", bb.getBankName());
	}

	@Test
	void testSetBankName() {
		bb.setBankName("KB");
		assertEquals("KB", bb.getBankName());
	}
	
	@Test
	void testSetBankNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> bb.setBankName(""));
	}

	@Test
	void testAddAccount() {
		Customer cc = new Customer("Sin", "Korea", "78/07/08");
		Date dd = new Date(8, 2, 2019);
		Account ac = new Account(cc, dd, 1000);
		
		ac.setAccountNumber("7878");
		
		bb.addAccount(ac);
		
		assertAll("Account Test",
				()-> assertEquals(1000, ac.getBalance()),
				()-> assertEquals(2019, bb.getAccount("7878").getDateAccountCreated().getYear()),
				()-> assertEquals("Sin", bb.getAccount("7878").getCustomer().getName())
				);
	}

	@Test
	void testGetAccount() {
		Customer cc = new Customer("Sin", "Korea", "78/07/08");
		Date dd = new Date(8, 2, 2019);
		Account ac = new Account(cc, dd, 1000);
		
		ac.setAccountNumber("7878");
		bb.addAccount(ac);
		
		assertNotNull(bb.getAccount("7878"));
	}

	@Test
	void testShowTransactions() {
		Customer cc = new Customer("Sin", "Korea", "78/07/08");
		Date dd = new Date(8, 2, 2019);
		Account ac = new Account(cc, dd, 1000);
		
		ac.setAccountNumber("7878");
		bb.addAccount(ac);
		
		TransactionRecord tr = new TransactionRecord(1000, dd, "7878", "deposit");
		ac.addTransaction(tr);
		System.out.println("****************************************");
		System.out.println("Show Transaction");
		bb.showTransactions("7878");
		System.out.println("****************************************");
		TransactionRecord tr1 = new TransactionRecord(500, dd, "7878", "deposit");
		ac.addTransaction(tr1);
		System.out.println("****************************************");
		System.out.println("Show Transaction");
		bb.showTransactions("7878");
		System.out.println("****************************************");
	}

	@Test
	void testDisplayAccountNumbers() {
		bb.displayAccountNumbers();
	}

	

}
