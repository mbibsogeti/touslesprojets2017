package fr.obodrel.travel.beans;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LakeTest {
	private Lake lakeToTest;
	
	@Before
	public void setUp() {
		lakeToTest = new Lake();
	}
	
	@Test
	public void testId() {
		lakeToTest.setId(11L);
		
		assertEquals(11L,lakeToTest.getId());
	}
	
	@Test
	public void testToString() {
		lakeToTest = new Lake(1L,"A","B",1f);
		
		assertEquals("Lake [ id=" + 1L + 
				", name = A" + ", country = " +
				"B, size = " + 1f + "]",
				lakeToTest.toString());
		
		lakeToTest.setSize(1000000000f);
		
		assertEquals("Lake [ id=" + 1L + 
				", name = A" + ", country = " +
				"B, size = " + 1000000000f + "]",
				lakeToTest.toString());
	}
	
	@Test
	public void testName() {
		lakeToTest.setName("AA");
		
		assertEquals("AA",lakeToTest.getName());
	}
	
	@Test
	public void testSetCountry() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		lakeToTest.setCountry("AA");
		Field countryField = lakeToTest.getClass().getDeclaredField("_country");
		countryField.setAccessible(true);
		assertEquals("AA",countryField.get(lakeToTest));
	}
	
	@Test
	public void testGetCountry() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field countryField = lakeToTest.getClass().getDeclaredField("_country");
		countryField.setAccessible(true);
		countryField.set(lakeToTest, "AA");
		assertEquals("AA",lakeToTest.getCountry());
	}
	
	@Test
	public void testSize() {
		lakeToTest.setSize(15.56f);
		
		assertEquals(15.56,lakeToTest.getSize(),0.001);
	}
	
	@After
	public void tearDown() {
		
	}
}
