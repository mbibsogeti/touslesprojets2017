package fr.ib.hugo.travel;

public class USA {

	public static void doWashington() {
		System.out.println("Nous ne disposons pas d'offre de voyage pour Washington en ce moment.");
		return;
	}

	public static void doNevada() {
		Destination d1 = new Destination("Death Valley", "Nevada", 1);
		d1.extend(6);
		System.out.println(d1.toString());

		Destination d2 = new Destination();
		d2.setName("Las Vegas");
		d2.setState("Nevada");
		d2.setDays(14);
		System.out.println(d2.toString());

		Destination d3 = new Destination();
		System.out.println(d3.toString());
		return;
	}

	public static void doTexas(){
		CoastalDestination d1=new CoastalDestination();
		
		d1.setName("Padre Island");
		d1.setState("Texas");
		d1.setDays(10);
//		d1.setBoat("bateau pêcheur");
		System.out.println(d1.toString());
	}
}