package fr.ib.spring.khady;

public class CruiseSource {
	private CruiseCalculator calculator;

	public boolean getActive() {
		return true;
	}

	public CruiseCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(CruiseCalculator calculator) {
		this.calculator = calculator;
	}

	public String getHelsinkiBergen(){
		calculator.setOrigin(CruiseCalculator.Location.HELSINKI);
		calculator.setDestination(CruiseCalculator.Location.BERGEN);
		return "Helsinki - Bergen: seulement " + calculator.getPrice() + " €";
	}
	
	
}
