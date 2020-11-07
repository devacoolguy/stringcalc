package test;

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.swissre.NotANumberException;
import com.swissre.StringCalc;

public class StringCalcTest {
	
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("String calculator test start");
	}
	
	@Test
	public void addNumbers() {
		assertEquals("0", StringCalc.addNumbers(null));
		assertEquals("0", StringCalc.addNumbers(""));
		assertEquals("8", StringCalc.addNumbers("8"));
		assertEquals("0", StringCalc.addNumbers("123"));
		assertEquals("5", StringCalc.addNumbers("2,3"));
		assertEquals("5", StringCalc.addNumbers("2  ,  3"));
		assertEquals("6", StringCalc.addNumbers("1 2 3"));
		assertEquals("6", StringCalc.addNumbers("1   2   3"));
		assertEquals("2", StringCalc.addNumbers("2, , "));
		assertEquals("12", StringCalc.addNumbers("2 101 10 "));
		assertEquals("One of the input is not a number", StringCalc.addNumbers("str"));
		assertEquals("One of the input is not a number", StringCalc.addNumbers("2 str 10 "));
		assertEquals("One of the input is negative number", StringCalc.addNumbers("-38"));
		assertEquals("One of the input is negative number", StringCalc.addNumbers("2,-3"));
	}
	
	@Test
	public void splitTest() {
		assertEquals("1",StringCalc.split("1,2,3")[0]);
		assertEquals("15",StringCalc.split("10 20 15")[2]);
	}
	
	@Test
	public void isNullOrEmprtTest() {
		assertEquals(true, StringCalc.isNullOrEmpty(""));
		assertEquals(true, StringCalc.isNullOrEmpty(null));
		assertEquals(false, StringCalc.isNullOrEmpty("str"));
	}
	
	@Test
	public void isNegativeTest() {
		assertEquals(true, StringCalc.isNegative(-1));
		assertEquals(false, StringCalc.isNegative(0));
		assertEquals(false, StringCalc.isNegative(15));
	}
	
	@Test
	public void isBigNumTest() {
		assertEquals(false, StringCalc.isBigNum(-1));
		assertEquals(false, StringCalc.isBigNum(0));
		assertEquals(true, StringCalc.isBigNum(1000));
	}
	
	@Test
	public void isNumTest() {
		try {
			assertEquals(7, StringCalc.isNum("7"));
			assertEquals(6, StringCalc.isNum("str"));
		}
		catch(NotANumberException e) {
			assertEquals("input is not a number", e.getMessage());
		}
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("String calculator test completed");
	}
}
