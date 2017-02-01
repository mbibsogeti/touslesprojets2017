package fr.ib.obodrel.travel;

import java.util.ArrayList;
import java.util.Scanner;

public class CanadaTravelDestination extends TravelDestination {

	protected int _canadaPricePerDay;
	protected int _canadaPlaneTicketPrice;
	ArrayList<Integer> _canadaTravelOptions;
	
	public CanadaTravelDestination() {
		super();
		_DestinationName = "Canada";
		_canadaPricePerDay = 45;
		_canadaPlaneTicketPrice = 795;

		_canadaTravelOptions = new ArrayList<Integer>();

		_canadaTravelOptions.add(7);
		_canadaTravelOptions.add(9);
		_canadaTravelOptions.add(13);
		_canadaTravelOptions.add(16);
		_canadaTravelOptions.add(18);

	}


	private void displayCanadaTravelInformation(int canadaPricePerDay, int canadaPlaneTicketPrice) {
		System.out.println("Available options to travel to " + _DestinationName + " are following :");

		for (int days : _canadaTravelOptions) {
			int canadaStayingCost;
			canadaStayingCost = days * canadaPricePerDay + canadaPlaneTicketPrice;
			System.out.println("Staying " + days + " days will cost you " + canadaStayingCost + "\u20ac!");
		}

		System.out.println("We hope you will find the option that suits you!");
	}
	
	protected void execute(Scanner cin) {
		
		displayCanadaTravelInformation(_canadaPricePerDay,_canadaPlaneTicketPrice);
	}
}
