package fr.ib.travel.cruise;

public class CruiseSource {
	private CruiseCalculator calculator;

	public Boolean getActive() {
		return true;
	}

	public CruiseCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(CruiseCalculator calculator) {
		this.calculator = calculator;
	}
	public String getHelsinkiBergen(){
		calculator.setOrigin(Location.HELSINKI);
		calculator.setDestination(Location.BERGEN);
		return "Helsinki-Bergen :" + calculator.getPrice();
	}
}
