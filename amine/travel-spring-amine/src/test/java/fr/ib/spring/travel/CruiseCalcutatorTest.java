package fr.ib.spring.travel;



import static org.junit.Assert.*;

import org.junit.Test;

public class CruiseCalcutatorTest {
	@Test
	public void testGetPrice() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		CruiseCalculator cc= new CruiseCalculator();
		cc.setBmPrice(340);
		cc.setMhPrice(220.90);
		cc.setOrigin(CruiseCalculator.Location.BERGEN);
		cc.setDestination(CruiseCalculator.Location.HELSINKI);
		assertEquals(560.90, cc.getPrice(),0.001);
	}
}
