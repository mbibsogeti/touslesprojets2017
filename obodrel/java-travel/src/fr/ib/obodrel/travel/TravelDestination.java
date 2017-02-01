package fr.ib.obodrel.travel;

import java.util.Scanner;

public abstract class TravelDestination {
	protected String _DestinationName;
	
	public TravelDestination(String destinationName) {
		_DestinationName = destinationName;
	}
	
	public TravelDestination() {
		_DestinationName = "";
	}

	protected String getDestinationName() {
		return _DestinationName;
	}
	
	protected void setDestinationName(String destinationName) {
		_DestinationName = destinationName;
	}
	
	protected void execute(Scanner cin) {}
}
