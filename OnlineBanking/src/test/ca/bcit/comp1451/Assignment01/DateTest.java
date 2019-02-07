package test.ca.bcit.comp1451.Assignment01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ca.bcit.comp1451.Assignment01.Date;

class DateTest {

	
	@Test
	void testDay() {
		Date dd = new Date(1, 2, 3);
		assertEquals(1, dd.getDay());
	}
	
	@Test
	void testDayInvalid() {
		Date dd = new Date(32, 2, 3);
		assertEquals(1, dd.getDay());
	}
	
	@Test
	void testMonth() {
		Date dd = new Date(1,13,3);
		assertNotEquals(13, dd.getMonth());
	}
	
	@Test
	void testMonthInvalid() {
		Date dd = new Date(1, 13, 3);
		assertEquals(1, dd.getMonth());
	}
	
	@Test
	void testYear() {
		Date dd = new Date(1,13,3);
		assertNotEquals(3, dd.getYear());
	}
	
	@Test
	void testYearInvalid() {
		Date dd = new Date(1, 13, 3);
		assertEquals(1900, dd.getYear());
	}
	
	@Test
	void testYearValid() {
		Date dd = new Date(1, 13, 2019);
		assertEquals(2019, dd.getYear());
	}
	
	@Test
	void testFormatDate() {
		Date dd = new Date(7, 2, 2019);
		String str = dd.formatDate();
		
		assertEquals("07/February/2019", str);
	}

}
