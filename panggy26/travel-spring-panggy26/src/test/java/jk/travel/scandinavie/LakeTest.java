package jk.travel.scandinavie;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class LakeTest {
	/**
	 * Cette classe sert à tester la classe Lake avec JUnit
	 */
	
	private Lake lac;
	
	// @Before : Java applique l'intérieur de cette méthode avant l'exécution de chacun des tests
	@Before
	public void setup() {
		//  Le nom setup est conventionnel. Instancie un nouveau lac avant chacun des tests.
		lac = new Lake();
	} // end setup method
	
//	// @After : Java applique l'intérieur de cette méthode après l'exécution de chacun des tests
//	@After
//	public void tearDown() {
//	}
//	Autres annotations : @BeforeClass et @AfterClass
	
	@Test
	public void testId() {
		// Mise en place des données
		lac.setId(11L);
		// Vérification : est-ce-qu'il lit bien un long valant 11 dans l'id de lac ?
		assertEquals(11L, lac.getId());
	} // end testId method
	
	@Test
	public void testName() {
		// Attention : on teste ici à la fois le getter et le setter. Cela n'est pas à proprement parlé unitaire.
		lac.setName("Lac Truc");
		assertEquals("Lac Truc", lac.getName());	
	} // end testName method
	
	@Test
	public void testCountry() {
		// Attention : on teste ici à la fois le getter et le setter. Cela n'est pas à proprement parlé unitaire : voir tests avec rélexion
		lac.setCountry("Späm Land");
		assertEquals("Späm Land", lac.getCountry());	
	} // end testCountry method
	
	// Exemple de test avec réflexion
	@Test
	public void testGetCountry() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// Cherche la classe de l'objet lac, prend le champ _country
		Field field = lac.getClass().getDeclaredField("_country");
		// Rend accessible le champ (car défini en private)
		field.setAccessible(true);
		// Lecture et conversion
		field.set(lac, "Norvège");
		assertEquals("Norvège", lac.getCountry());
	}
	
	// Exemple de test avec réflexion
	@Test
	public void testSetCountry() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		lac.setCountry("Finlande");
		// Cherche la classe de l'objet lac, prend le champ _country
		Field field = lac.getClass().getDeclaredField("_country");
		// Rend accessible le champ (car défini en private)
		field.setAccessible(true);
		// Lecture et conversion
		String c = (String) field.get(lac);
		assertEquals("Finlande", c);
	}
	
	@Test
	public void testSize() {
		// Attention : on teste ici à la fois le getter et le setter. Cela n'est pas à proprement parlé unitaire.
		lac.setSize(10000);
		// Couvrir les erreurs de marge 0.001 dues à la comparaison des chiffres flottants en Java
		assertEquals(10000, lac.getSize(), 0.001);
	} // end testSize method
	
	@Test
	public void testToString() {
		// Mise en place
		Lake lac = new Lake(1, "Lac Truc", "Suède", 10000);
		// Vérification
		assertEquals("Id : 1, Name : Lac Truc, Country : Suède, Size : 10000.0 km²", lac.toString());
		// 2nd test : ne fonctionne pas à cause de 1.0E8
		lac.setSize(100000000);
		assertEquals("Id : 1, Name : Lac Truc, Country : Suède, Size : 100000000.0 km²", lac.toString());
	} // end testToString method
} // end LakeTest class