package test.ca.bcit.comp1451.Assignment01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.bcit.comp1451.Assignment01.Date;
import ca.bcit.comp1451.Assignment01.TransactionRecord;

class TransactionRecordTest {
	
	TransactionRecord tr = null;
	
	@BeforeEach
	void prep() {
		Date dd = new Date(7, 2, 2019);
		
		tr = new TransactionRecord(1000, dd, "1000", "deposit");
	}

	@Test
	void testTransactionRecord() {
		assertNotNull(tr);
	}

	@Test
	void testGetAmount() {
		assertEquals(1000, tr.getAmount());
	}

	@Test
	void testSetAmount() {
		tr.setAmount(2000);
		
		assertEquals(2000, tr.getAmount());
	}
	
	@Test
	void testSetAmountInvalid() {
		
		assertThrows(IllegalArgumentException.class, () -> tr.setAmount(-1));
	}

	@Test
	void testGetDate() {
		assertNotNull(tr.getDate());
	}

	@Test
	void testSetDate() {
		Date dd = new Date(9, 2, 2019);
		tr.setDate(dd);
		assertEquals(9, tr.getDate().getDay());
	}
	
	@Test
	void testSetDateNull() {
		assertThrows(IllegalArgumentException.class, () -> tr.setDate(null));
	}

	@Test
	void testGetAccountNumber() {
		assertEquals("1000", tr.getAccountNumber());
	}

	@Test
	void testSetAccountNumber() {
		tr.setAccountNumber("2000");
		
		assertEquals("2000", tr.getAccountNumber());
	}
	
	@Test
	void testSetAccountNumberNull() {
		assertThrows(IllegalArgumentException.class, () -> tr.setAccountNumber(null));
	}

	@Test
	void testGetTransactionType() {
		assertEquals("deposit", tr.getTransactionType());
	}

	@Test
	void testSetTransactionType() {
		tr.setTransactionType("withdraw");
		
		assertEquals("withdraw", tr.getTransactionType());
	}
	
	@Test
	void testSetTransactionTypeInvalid() {
		assertThrows(IllegalArgumentException.class, () -> tr.setTransactionType("") );
	}

	@Test
	void testDisplayTransaction() {
		tr.displayTransaction();
	}

}
