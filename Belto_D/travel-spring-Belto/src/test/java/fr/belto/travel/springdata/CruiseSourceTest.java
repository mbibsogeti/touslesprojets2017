package fr.belto.travel.springdata;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import fr.belto.travel.scandinaves.CruiseCalculator;
import fr.belto.travel.scandinaves.CruiseSource;

public class CruiseSourceTest {
@Test
public void testGetActive(){
	CruiseSource cs= new CruiseSource();
	assertTrue("cs devrait etre cool",cs.getActive());// le premier paramètre est un message qui s'affiche en cas d'erreur
// pour le tester on met assertFalse et on aura le message d'erreur!!!
}
@Test
public void testGetHelsinkiBergen(){
	CruiseSource cs= new CruiseSource();
	cs.setCalculator(new CruiseCalculator());
// assertThat verifie juste une partie de la chaine, ici on regarde s'il y a Bergen
	assertThat(cs.getHelsinkiBergen(),containsString("Bergen"));
}


}
