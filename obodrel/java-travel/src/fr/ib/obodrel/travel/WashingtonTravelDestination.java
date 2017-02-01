package fr.ib.obodrel.travel;

import java.util.Scanner;

public class WashingtonTravelDestination extends UnitedStatesTravelDestination {

	public WashingtonTravelDestination() {
		super();
		_DestinationId ="w";
		_travelDuration = 9;
		_DestinationName = "Washington";
	}

	@Override
	protected void execute(Scanner cin) {
		super.execute(cin);
	}
}
