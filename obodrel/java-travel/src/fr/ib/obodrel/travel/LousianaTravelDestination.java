package fr.ib.obodrel.travel;

import java.util.Scanner;

public class LousianaTravelDestination extends UnitedStatesTravelDestination {
	
	public LousianaTravelDestination() {
		super();
		_DestinationName = "Lousiana";
		_travelDuration = 8;
		_DestinationId ="l";
	}	
		
	protected void execute(Scanner cin) {
		super.execute(cin);
		System.out.println("Please choose the correct username and location to validate your travel!");
		chooseUsername(cin);
		chooseLocation(cin);
		toString();
	}

}
