package fr.ib.spring.travel;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class CruiseSourceTest {
	@Test
	public void testGetActive() {
		CruiseSource cs = new CruiseSource();
		assertTrue(cs.getActive());
		// assertFalse("cs devrait être ouvert", cs.getActive());
		assertSame(cs, cs);
		if (!cs.getActive())
			fail();
	}

	@Test
	public void testGetHelsinkiBergen() {
		CruiseSource cs = new CruiseSource();
		cs.setCalculator(new CruiseCalculator());
		// faire une doublure grâce à Mockito voir les deux lignes suivantes:
		// @ Mock CruiseCalculator cc;
		// cs.setCalculator(cc);
		assertThat(cs.getHelsinkiBergen(), containsString("Bergen"));
	}
}
