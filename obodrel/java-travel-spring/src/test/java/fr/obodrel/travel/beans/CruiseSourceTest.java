package fr.obodrel.travel.beans;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class CruiseSourceTest {
	private CruiseSource cruisesourceToTest;
	
	@Before
	public void setUp() {
		cruisesourceToTest = new CruiseSource();
		cruisesourceToTest.setCalculator(new CruiseCalculator());
	}
	
	@Test
	public void testGetActive() {
		assertTrue(cruisesourceToTest.getActive());
		assertSame(true,cruisesourceToTest.getActive());
	}

	@Test
	public void testGetHelsinkiBergen() {
		assertThat(cruisesourceToTest.getHelsinkiBergen(), containsString("Bergen"));
	}
}
