package fr.ib.obodrel.travel;

import java.util.Scanner;

public class NevadaTravelDestination extends UnitedStatesTravelDestination {

	public NevadaTravelDestination() {
		super();
		_DestinationId = "n";
		_travelDuration = BASE_TRAVEL_DURATION;
		_DestinationName = "Nevada";
	}

	public NevadaTravelDestination(int travelDuration, String locationName, String destinationName) {
		super();
		_DestinationId = "n";
		_DestinationId = locationName;
		_travelDuration = travelDuration;
		_DestinationName = destinationName;
	}

	protected void execute(Scanner cin) {
		super.execute(cin);
		System.out.println("Your travel is set to last " + Math.round(getTravelDurationWeeks()) + " weeks and "
				+ (_travelDuration - 7 * Math.round(getTravelDurationWeeks())) + " days.");
	}
}
