package test.ca.bcit.comp1451.Assignment01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.bcit.comp1451.Assignment01.Account;
import ca.bcit.comp1451.Assignment01.Customer;
import ca.bcit.comp1451.Assignment01.Date;
import ca.bcit.comp1451.Assignment01.TransactionRecord;

class AccountTest {
	
	Account ac = null;
	
	@BeforeEach
	void prepTest() {
		Customer cc = new Customer("Sin", "Korea", "78/07/08");
		Date dd = new Date(9, 2, 2019);
		ac = new Account(cc, dd, 1000);
	}

	@Test
	void testAccount() {
		assertNotNull(ac);
	}

	@Test
	void testGetCustomer() {
		assertNotNull(ac.getCustomer());
	}

	@Test
	void testSetCustomer() {
		Customer c1 = new Customer("Frank", "Canada", "72/01/01");
		ac.setCustomer(c1);
		assertEquals(c1.getName(), ac.getCustomer().getName());
	}

	@Test
	void testGetAccountNumber() {
		assertNotNull( ac.getAccountNumber());
	}

	@Test
	void testSetAccountNumber() {
		ac.setAccountNumber("1001");
		assertEquals("1001", ac.getAccountNumber());
	}

	@Test
	void testGetDateAccountCreated() {
		assertNotNull(ac.getDateAccountCreated());
	}

	@Test
	void testSetDateAccountCreated() {
		Date d1 = new Date(18, 2, 2019);
		ac.setDateAccountCreated(d1);
		
		assertEquals(2, ac.getDateAccountCreated().getMonth());
	}

	@Test
	void testGetBalance() {
		assertEquals(1000, ac.getBalance());
	}

	@Test
	void testSetBalance() {
		ac.setBalance(2000);
		
		assertEquals(2000, ac.getBalance());
	}

	@Test
	void testDeposit() {
		ac.deposit(1000);
		assertEquals(2000, ac.getBalance());
	}
	
	@Test
	void testDepositInvalid() {
		assertEquals(false, ac.deposit(-1));
	}

	@Test
	void testWithdraw() {
		ac.setBalance(1000);
		
		ac.withdraw(100);
		
		assertEquals(900, ac.getBalance());
	}
	
	@Test
	void testWithdrawInvalid() {
		assertEquals(false, ac.withdraw(1000000));
	}

	@Test
	void testAddTransaction() {
		Date dd = new Date(9, 2, 2019);
		TransactionRecord tr = new TransactionRecord(7777, dd, "Acc-1000", "deposit");
		
		ac.addTransaction(tr);
		
		System.out.println("-----------------------------------");
		System.out.println("Transaction Display");
		System.out.println("-----------------------------------");
		ac.transactionDisplay();
		System.out.println("-----------------------------------");
	}


	@Test
	void testDisplayAccountInfo() {
		System.out.println("###################################");
		System.out.println("Account Information");
		System.out.println("###################################");
		ac.displayAccountInfo();
		System.out.println("###################################");
	}

}
