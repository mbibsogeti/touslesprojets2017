package fr.belto.travel.springdata;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
// on fait le test avec des annotations, c'est valable depuis Java 5
// @Test, on ajoute JUnit4 library...
// pour lancer le test, click droit sur la class test, run as Junit test
// Nouvelle fenetre, bar verte=pas d'erreur( yeaaaaaaah!!!)
public class LakeTest {
	private Lake l;
// before veut dire de faire ceci avant chaque test (on le fait car on ne saurait pas pourquoi
@Before
public void setUp(){
	l=new Lake();
}
// on peut avoir des @after (deconnexion, deconstruction)
@Test	
public void testId(){
//	Lake l=new Lake(); ne sert plus à rien car il y a before
	l.setId(11L);// valeur attendue
	assertEquals(new Long(11L),l.getId());// comparaison entre le resultat et la valeur attendue 
// assertEquals, comparaison de chaine (a droite ce qu'on obtien et à gauche ce qu'on attend
}

@Test
// un test peut avoir plusieur assertEquals
// on test la fonction ToString()
public void testToString(){
//	Lake m= new Lake();
	l.setId(2L);
	l.setName("Belto");
	l.setCountry("Haiti");
	l.setSize(1000000F);
	assertEquals("Lake [id=2, name=Belto, country=Haiti, size=1000000.0]", l.toString());
	l.setSize(100000000);
	assertEquals("Lake [id=2, name=Belto, country=Haiti, size=1.0E8]", l.toString());
}
@Test
public void testName(){
//	Lake l= new Lake();
	l.setName("Belto");
	assertEquals("Belto",l.getName());
}
@Test
public void testCountry(){
//	Lake m= new Lake();
	l.setCountry("Haiti");
	assertEquals("Haiti",l.getCountry());
}
@Test
public void testSize(){
//	Lake m= new Lake();
	l.setSize(50f);
// pour les float et les double, il y a toujours les erreurs donc on rajoute un delta (0.01) pour combler 
	assertEquals(50f,l.getSize(),0.01);
}
// test Reflection, on va tester la fonction set() et get()
@Test
public void testSetCountry() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	l.setCountry("Finlande");
	Field f=l.getClass().getDeclaredField("country");//aller dans la class l, trouver le champ country
	f.setAccessible(true);// rend accessible le champ à tester dans la classe
	String c=(String)f.get(l);// on le stock dans c
	assertEquals("Finlande",c);// on fait la comparaison
}
@Test
public void testGetCountry() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	Field f=l.getClass().getDeclaredField("country");// on accède directement au champ contry
	f.setAccessible(true);// on le rend accessible
	f.set(l, "Norvège");// on ajoute Norvège sans passer par set
	assertEquals("Norvège",l.getCountry());// on fait la comparaison!
}
}
