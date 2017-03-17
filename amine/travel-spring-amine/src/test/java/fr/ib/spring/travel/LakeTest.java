package fr.ib.spring.travel;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LakeTest {
	private Lake l;

	@Before
	public void setUp() {
		l = new Lake();
	}

	// déconnecter du test
	@After
	public void tearDown() {

	}

	@Test
	public void testId() {
		l.setId(11L);
		assertEquals(new Long(11L), l.getId());
	}

	@Test
	public void testToString() {
		Lake l = new Lake(11L, "Alger", "Algérie", 20);
		assertEquals("11: Alger se trouve au Algérie avec une supérficie de: 20.0km²", l.toString());
		l.setSize(1000000000);
		assertEquals("11: Alger se trouve au Algérie avec une supérficie de: 1.0E9km²", l.toString());
	}

	@Test
	public void testName() {
		l.setName("coucou");
		assertEquals("coucou", l.getName());
	}

	@Test
	public void testCounrty() {
		l.setCountry("holà");
		assertEquals("holà", l.getCountry());
	}

	@Test
	public void testSize() {
		l.setSize(2000);
		assertEquals(2000, l.getSize(), 0.001);
	}

	// test du fonctionnement du setCountry()
	@Test
	public void testSetCountry()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		l.setCountry("Finlande");
		Field f = l.getClass().getDeclaredField("country");
		// accéder à l'attribut déclarer private
		f.setAccessible(true);
		String c = (String) f.get(l);
		assertEquals("Finlande", c);
	}

	// test du fonctionnement du getCountry()
	@Test
	public void testGetCountry()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f = l.getClass().getDeclaredField("country");
		f.setAccessible(true);
		f.set(l, "Norvège");
		assertEquals("Norvège", l.getCountry());
	}
}
