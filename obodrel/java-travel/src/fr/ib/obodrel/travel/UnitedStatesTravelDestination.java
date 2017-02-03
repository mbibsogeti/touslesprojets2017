package fr.ib.obodrel.travel;

import java.util.Scanner;

public class UnitedStatesTravelDestination extends TravelDestination {

	public UnitedStatesTravelDestination() {
		super();
		_DestinationId = "us";
		_travelDuration = BASE_TRAVEL_DURATION;
		_DestinationName = "The United States";
	}

	protected void execute(Scanner cin) {
		super.execute(cin);
	}
}
