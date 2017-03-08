package cruise;

public class CruiseSource {

	// On fait ici de l'agrégation d'objets
	public CruiseCalculator calculator;
	
	public String getHelsinkiBergen() {
		calculator.setOrigin(CruiseCalculator.Location.HELSINKI);
		calculator.setDestination(CruiseCalculator.Location.BERGEN);
		return "Helsinki - Bergen: "+calculator.getPrice();
	}

	public CruiseCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(CruiseCalculator calculator) {
		this.calculator = calculator;
	}

	public boolean getActive() {
		return true;
	}

}
