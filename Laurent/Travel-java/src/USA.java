
public class USA {

	public USA() {
		// TODO Auto-generated constructor stub
	}

	static void doWashington(){
		System.out.println("Malheureusement, il n'y a pas de voyage prévu pour cet état.");
	}
	
	static void doNevada(){
		Destination dNev = new Destination("Reno","Nevada",1);
		
		dNev.extendDays(7);
		System.out.println(dNev.toString());
	}
}
