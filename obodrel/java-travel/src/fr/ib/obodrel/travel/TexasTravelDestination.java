package fr.ib.obodrel.travel;

import java.util.Scanner;

public class TexasTravelDestination extends UnitedStatesTravelDestination {

	public TexasTravelDestination() {
		super();
		_DestinationName = "Texas";
		_travelDuration = 15;
		_DestinationId ="t";
	}
	
	@Override
	protected void execute(Scanner cin) {
		super.execute(cin);
	}
}