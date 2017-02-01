package fr.ib.obodrel.travel;

import java.util.Scanner;

public class NevadaTravelDestination extends UnitedStatesTravelDestination {

	public NevadaTravelDestination() {
		super();
		_DestinationId ="n";
		_travelDuration = 10;
		_DestinationName = "Nevada";
	}
	
	public NevadaTravelDestination(int travelDuration, String locationName, String destinationName) {
		super();
		_DestinationId ="n";
		_DestinationId =locationName;
		_travelDuration = travelDuration;
		_DestinationName = destinationName;
	}

	@Override
	protected void execute(Scanner cin) {
		super.execute(cin);
	}
}
