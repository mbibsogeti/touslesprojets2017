package fr.ib.obodrel.travel;

import java.util.Scanner;

public class SaskatchewanTravelDestination extends CanadaTravelDestination {
	
	public SaskatchewanTravelDestination() {
		super();
		_DestinationName = "Saskatchewan";
		_travelDuration = 8;
		_DestinationId ="s";
		_canadaPricePerDay = 65;
		_canadaPlaneTicketPrice = 815;
	}
	
	@Override
	protected void execute(Scanner cin) {
		super.execute(cin);
	}
}
