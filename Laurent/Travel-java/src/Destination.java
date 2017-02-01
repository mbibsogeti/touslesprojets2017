
public class Destination {

	String name,state;
	int days;
	
	Destination(){
		this(null,null,0);
	}
	
	Destination(String n, String s, int d){
		name=n;
		state=s;
		days=d;
	}
	
	void extendDays(int d){
		days+=d;
	}
	
	public String toString(){
		String tempText = "Voyager a "+name+" de l'état "+state+" ne peut se faire que pour un séjour de "+days+" jours";
		return tempText;
	}
}
