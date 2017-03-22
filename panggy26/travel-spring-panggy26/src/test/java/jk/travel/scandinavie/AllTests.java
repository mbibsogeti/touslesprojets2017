package jk.travel.scandinavie;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Utilisation d'une suite de tests
@RunWith(Suite.class)

// Définition des classes de tests contenues dans la Suite
@Suite.SuiteClasses({
	LakeTest.class, CruiseCalculator.class
})

public class AllTests {
}