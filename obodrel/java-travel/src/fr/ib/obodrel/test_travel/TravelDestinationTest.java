package fr.ib.obodrel.test_travel;

import fr.ib.obodrel.travel.CanadaTravelDestination;
import junit.framework.TestCase;

public class TravelDestinationTest extends TestCase {
	public void testAddTravelDuration() {
		CanadaTravelDestination CanadaToTest = new CanadaTravelDestination();
		assertNotNull(getName(), CanadaToTest);
		CanadaToTest.setTravelDuration(3);
		assertEquals(3,CanadaToTest.getTravelDuration());
		CanadaToTest.addTravelDuration(5);
		assertEquals(8,CanadaToTest.getTravelDuration());
	}
}
