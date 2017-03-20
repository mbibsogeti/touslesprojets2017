package jk.travel.scandinavie;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CruiseSourceTest {
	
// ATTRIBUTS //
	private CruiseSource cs;

	// MÉTHODES //
	
	@Before
	public void setup() {
		//  Le nom setup est conventionnel. Instancie un nouveau CruiseCalculator avant chacun des tests.
		// Écrire CruiseSource cs = new CruiseSource(); revient à déclarer un nouvel objet. C'EST MAL !
		cs = new CruiseSource();
	} // end setup method
	
	@Test
	public void testGetActive() {
		// assertTrue : pour tester une méthode qui renvoie un booléen true (il existe aussi assertFalse)
		// On peut ajouter en 1er argument une explication qui s'affiche dans JUnit, Failure Trace si le test échoue
		assertTrue("cs devrait être ouvert", cs.getActive());
		// Autre assert : assertSame(cs, cs)
		assertSame(cs, cs);
		// Autre façon que assertTrue mais en moins élégant
		if(!cs.getActive()) {
			// fail fait toujours échouer le test. TOUJOURS.
			fail("dfsfsd");
		} // end if
	} // end testGetActive method
	
	@Test
	public void testGetHelsinkiBergen() {
		cs.setCalculator(new CruiseCalculator());
		assertThat(cs.getHelsinkiBergen(), containsString("Bergen"));
	}
} // end CruiseSourceTest class