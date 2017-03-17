package jk.travel.scandinavie;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CruiseCalculatorTest {
	
	// ATTRIBUTS //
	private CruiseCalculator cc;

	// MÉTHODES //
	
	@Before
	public void setup() {
		//  Le nom setup est conventionnel. Instancie un nouveau CruiseCalculator avant chacun des tests.
		// Écrire CruiseCalculator cc = new CruiseCalculator(); revient à déclarer un nouveau cc. C'EST MAL !
		cc = new CruiseCalculator();
		cc.setPriceMalmoBergen(340);
		cc.setPriceMalmoHelsinki(220.9);
	} // end setup method
	
	@Test
	public void testGetPrice() {
		// CAS 1
		// Préparation
		cc.setOrigin(CruiseCalculator.Location.BERGEN);
		cc.setDestination(CruiseCalculator.Location.HELSINKI);
		// Validation
		assertEquals(340 + 220.9, cc.getPrice(), 0.01);
		// CAS 2
		// Préparation
		cc.setOrigin(CruiseCalculator.Location.BERGEN);
		cc.setDestination(CruiseCalculator.Location.MALMO);
		// Validation
		assertEquals(340, cc.getPrice(), 0.01);
		// CAS 2
		// Préparation
		cc.setOrigin(CruiseCalculator.Location.HELSINKI);
		cc.setDestination(CruiseCalculator.Location.MALMO);
		// Validation
		assertEquals(220.9, cc.getPrice(), 0.01);
	}
}