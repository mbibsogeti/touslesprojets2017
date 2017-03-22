package fr.obodrel.travel.beans;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.obodrel.travel.resources.CruiseInformationsHolder;
import fr.obodrel.travel.resources.CruiseInformationsHolder.LocationEnum;

public class CruiseCalculatorTest {
	private CruiseCalculator cruiseCalculatorToTest;
	
	@Before
	public void setUp() {
		cruiseCalculatorToTest = new CruiseCalculator();
	}
	
	@Test
	public void testGetPrice() {
		cruiseCalculatorToTest.setOrigin(LocationEnum.BERGEN);
		cruiseCalculatorToTest.setDestination(LocationEnum.MALMO);
		
		assertEquals(CruiseInformationsHolder.BERGEN_TO_MALMO_PRICE, cruiseCalculatorToTest.getPrice(),0.001);

		cruiseCalculatorToTest.setOrigin(LocationEnum.MALMO);
		cruiseCalculatorToTest.setDestination(LocationEnum.BERGEN);
		
		assertEquals(CruiseInformationsHolder.BERGEN_TO_MALMO_PRICE, cruiseCalculatorToTest.getPrice(),0.001);

		cruiseCalculatorToTest.setOrigin(LocationEnum.HELSINKI);
		cruiseCalculatorToTest.setDestination(LocationEnum.MALMO);

		assertEquals(CruiseInformationsHolder.HELSINKI_TO_MALMO_PRICE, cruiseCalculatorToTest.getPrice(),0.001);
		
		cruiseCalculatorToTest.setOrigin(LocationEnum.MALMO);
		cruiseCalculatorToTest.setDestination(LocationEnum.HELSINKI);

		assertEquals(CruiseInformationsHolder.HELSINKI_TO_MALMO_PRICE, cruiseCalculatorToTest.getPrice(),0.001);

		cruiseCalculatorToTest.setOrigin(LocationEnum.HELSINKI);
		cruiseCalculatorToTest.setDestination(LocationEnum.BERGEN);

		assertEquals(CruiseInformationsHolder.HELSINKI_TO_MALMO_PRICE+CruiseInformationsHolder.BERGEN_TO_MALMO_PRICE, cruiseCalculatorToTest.getPrice(),0.001);
		
		cruiseCalculatorToTest.setOrigin(LocationEnum.BERGEN);
		cruiseCalculatorToTest.setDestination(LocationEnum.HELSINKI);

		assertEquals(CruiseInformationsHolder.HELSINKI_TO_MALMO_PRICE+CruiseInformationsHolder.BERGEN_TO_MALMO_PRICE, cruiseCalculatorToTest.getPrice(),0.001);

		cruiseCalculatorToTest.setOrigin(LocationEnum.BERGEN);
		cruiseCalculatorToTest.setDestination(LocationEnum.BERGEN);

		assertEquals(0, cruiseCalculatorToTest.getPrice(),0.001);
		
		cruiseCalculatorToTest.setOrigin(LocationEnum.HELSINKI);
		cruiseCalculatorToTest.setDestination(LocationEnum.HELSINKI);

		assertEquals(0, cruiseCalculatorToTest.getPrice(),0.001);
		
		cruiseCalculatorToTest.setOrigin(LocationEnum.MALMO);
		cruiseCalculatorToTest.setDestination(LocationEnum.MALMO);

		assertEquals(0, cruiseCalculatorToTest.getPrice(),0.001);
	}

	
}
