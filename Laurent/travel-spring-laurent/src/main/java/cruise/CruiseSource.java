package cruise;

//Bean
public class CruiseSource {

	//Utilisation d'un autre bean
	private CruiseCalculator calculator;
	
	//Déclaration des outils d'accès au bean
	public CruiseCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(CruiseCalculator calculator) {
		this.calculator = calculator;
	}

	//Méthode de test d'accès au bean
	public boolean getActive(){
		return true;
	}
	
	//Méthode d'utilisation du bean appellé
	public String getHelsinkiBergen(){
		calculator.setOrigin(CruiseCalculator.Location.HELSINKI);
		calculator.setDestination(CruiseCalculator.Location.BERGEN);
		return "Helsinki - Bergen à seulement "+String.format("%.2f", calculator.getPrice())+"\u20ac";
	}
}
