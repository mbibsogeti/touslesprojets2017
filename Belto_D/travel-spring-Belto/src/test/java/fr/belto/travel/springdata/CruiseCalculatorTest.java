package fr.belto.travel.springdata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.belto.travel.scandinaves.CruiseCalculator;


public class CruiseCalculatorTest {
	CruiseCalculator cc;
@Before
public void setUp(){
	  cc=new CruiseCalculator();
		double prix1=340;
		double prix2=220.90;
		cc.setPrix1(prix1);
		cc.setPrix2(prix2);
}	

@Test	
	public void testGetPrice(){
    cc.setOrigin(CruiseCalculator.Location.Bergen);
    cc.setDestination(CruiseCalculator.Location.Helsinki);
    assertEquals(560.90,cc.getPrice(),0.01);	
}
}