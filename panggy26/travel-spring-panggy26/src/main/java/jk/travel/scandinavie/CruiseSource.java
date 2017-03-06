package jk.travel.scandinavie;

public class CruiseSource {
	
	// ATTRIBUTS //
	private CruiseCalculator _calculator;

	// MÉTHODES //
	public boolean getActive() {
		return true;
	} // end getActive method
	
	public CruiseCalculator getCalculator() {
		return _calculator;
	}

	public void setCalculator(CruiseCalculator calculator) {
		_calculator = calculator;
	}
	
	public String getHelsinkiBergen() {
		_calculator.setOrigin(CruiseCalculator.Location.HELSINKI);
		_calculator.setDestination(CruiseCalculator.Location.BERGEN);
		return "Helsinki - Bergen : " + _calculator.getPrice() + " €";	
	} // end getHelsinkiBergen
} // end CruiseSource class