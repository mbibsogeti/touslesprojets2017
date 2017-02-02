package fr.ib.nicolas.travel;

public class DestinationMaritime extends Destination { // sous classe de la
														// classe dedstinatio,

	private String boat;
	
	public DestinationMaritime() {
		
	}
	public DestinationMaritime(String n, String m, int d, String b) {
		super(n, m, d);
		boat = b;
	}

	public String getBoat() {
		return boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}

	public String toString() {

		String nametout;
		nametout = getName() + getState();
		return nametout;
	}// return super.toString + ... le super commence par la mère puis la grand
		// mère puis , l 'arrière grand mere et this commence par la fille et
		// pareil remonte vers la mère..

	

}
