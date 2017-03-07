package fr.ib.spring.travel;

public class CruiseSource {
	public boolean getActive() {
		return true;
	}

	private CruiseCalculator calculator;

	public CruiseCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(CruiseCalculator calculator) {
		this.calculator = calculator;
	}

	public String getHelsinkiBergen() {
		calculator.setOrigin(CruiseCalculator.Location.HELSINKI);
		calculator.setDestination(CruiseCalculator.Location.BERGEN);
		return "Helsinki - Bergen seulement " + calculator.getPrice() + " €";
	}
}