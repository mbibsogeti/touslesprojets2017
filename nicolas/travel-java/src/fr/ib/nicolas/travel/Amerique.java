package fr.ib.nicolas.travel;

public class Amerique {

	static void dotexas() {
		Destinationmaritime d1 = new Destinationmaritime();
		d1.setName("toto");
		d1.setDays(1);
		d1.setState("toto");
		d1.setBoat("titan");
		System.out.println(d1.toString());
	}

	public static void main(String[] args) {

	}
	static void donevada() {
		System.out.println("neuneu");
		Destination d1 = new Destination("to", "ta", 0);

		// ou Destination d1=null qui va initialisé l o,"ta",0bjet d1; d1 = new
		// Destination();

		// d1.name= "nevaaada";
		// d1.extend(6);
		System.out.println(d1.toString());

	}

	static void dowashingtown() { // fonction appeler par l'autre classe voyage
									// 2

		System.out.println("messagedelautreclass");

	}

	

}
