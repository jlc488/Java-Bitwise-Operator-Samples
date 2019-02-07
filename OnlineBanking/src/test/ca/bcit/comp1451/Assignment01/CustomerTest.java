package test.ca.bcit.comp1451.Assignment01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.bcit.comp1451.Assignment01.Customer;

class CustomerTest {

	Customer cc = null;
	
	@BeforeEach
	void setPrep() {
		cc = new Customer("sin", "Korea", "78/07/08");
		
	}

	@Test
	void testCustomer() {
		
		assertNotNull(cc);
	}
	
	@Test
	void testGetName() {
		assertTrue(cc.getName().equals("sin"));
	}
	
	@Test
	void testSetName() {
		cc.setName("Frank");
		assertEquals("Frank", cc.getName());
	}
	
	@Test
	void testSetNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> cc.setName(""));
	}

	@Test
	void testGetAddress() {
		assertTrue(cc.getAddress().equals("Korea"));
	}

	@Test
	void testSetAddress() {
		assertThrows(IllegalArgumentException.class, () -> cc.setAddress(""));
	}

	@Test
	void testGetDob() {
		assertEquals("78/07/08", cc.getDob());
	}

	@Test
	void testSetDob() {
		assertThrows(IllegalArgumentException.class, () -> cc.setDob(""));
	}

	@Test
	void testFormatName() {
		cc.setName("frank");
		assertEquals("Frank", cc.formatName(cc.getName()));
	}

	@Test
	void testDisplayInformation() {
		
		cc.displayInformation();
	}

}
