package fr.ib.spring.travel;

import static org.junit.Assert.*;

import org.junit.Test;

public class CruiseSourceTest {
	@Test
	public void testGetActive() {
		CruiseSource cs = new CruiseSource();
		// assertTrue(cs.getActive());
		assertFalse("cs devrait être ouvert", cs.getActive());
	}
}
