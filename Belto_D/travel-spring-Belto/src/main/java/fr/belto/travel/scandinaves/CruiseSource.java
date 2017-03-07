package fr.belto.travel.scandinaves;
public class CruiseSource {
	// creation d'un boolean qui renvoie true
	public boolean getActive (){ 
	return true;
}
// nouvel objet Calcul avec getter et setter
private CruiseCalculator calculator;

	public CruiseCalculator getCalculator() {
	return calculator;
}

public void setCalculator(CruiseCalculator calculator) {
	this.calculator = calculator;
}
//calcul du tarif (Helsinki vs bergen) dans cruise source
	public String getHelsinkiBergen(){
		calculator.setOrigin(CruiseCalculator.Location.Helsinki);
		calculator.setDestination(CruiseCalculator.Location.Bergen);
		return "Helsinki-Bergen+"+"seulement"+calculator.getPrice();
	}
}
