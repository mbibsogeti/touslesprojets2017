package fr.belto.travel.springdata;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
LakeTest.class, CruiseCalculatorTest.class, CruiseSourceTest.class})
@RunWith(Suite.class)
public class AllTest {

}
