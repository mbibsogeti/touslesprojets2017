
public class Destination {

	String name,state;
	int days=0;
	
	void extendDays(int d){
		days+=d;
	}
	
	public String toString(){
		String tempText = "Voyager a "+name+" de l'état "+state+" ne peut se faire que pour un séjour de "+days+" jours";
		return tempText;
	}
}
