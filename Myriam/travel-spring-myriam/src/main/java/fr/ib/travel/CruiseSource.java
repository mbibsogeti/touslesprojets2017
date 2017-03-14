package fr.ib.travel;

public class CruiseSource {
	
	private CruiseCalculator calculator;
	
	public boolean getActive(){
		return true;
	}

	public String getHelsinkiBergen(){
		calculator.setOrigin(CruiseCalculator.Location.HELSINKI);
		calculator.setDestination(CruiseCalculator.Location.BERGEN);
		return "Helsinki-Bergen : seulement "+calculator.getPrice();
	}
	
	public CruiseCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(CruiseCalculator calculator) {
		this.calculator = calculator;
	}
	
	
}
