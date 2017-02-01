package fr.ib.obodrel.travel;

import java.util.Scanner;

public class UnitedStatesTravelDestination extends TravelDestination {

	public UnitedStatesTravelDestination() {
		super();
		_DestinationId = "us";
		_travelDuration = 3;
		_DestinationName = "The United States";
	}

	@Override
	protected void execute(Scanner cin) {
		super.execute(cin);
	}
}
