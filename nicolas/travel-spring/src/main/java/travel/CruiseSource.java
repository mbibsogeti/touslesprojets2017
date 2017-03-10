package travel;

public class CruiseSource {

	public boolean getActive(){ 
		return true;
	}
	public CruiseCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(CruiseCalculator calculator) {
		this.calculator = calculator;
	}

	private CruiseCalculator calculator;

	public String getHelsinkiBergen() {
		calculator.setOrigin(CruiseCalculator.Location.HELSINKI);
		calculator.setDestination(CruiseCalculator.Location.BERGEN);
		return "helsinki-bergen" + "seulement" + calculator.getPrice();
	}
}
