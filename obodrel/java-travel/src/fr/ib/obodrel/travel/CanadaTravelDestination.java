package fr.ib.obodrel.travel;

import java.util.ArrayList;
import java.util.Scanner;

public class CanadaTravelDestination extends TravelDestination {

	protected int _canadaPricePerDay;
	protected int _canadaPlaneTicketPrice;
	protected ArrayList<Integer> _canadaTravelOptions;
	
	public CanadaTravelDestination() {
		super();
		_DestinationId = "c";
		_DestinationName = "Canada";
		_travelDuration = 7;
		_canadaPricePerDay = 45;
		_canadaPlaneTicketPrice = 795;

		_canadaTravelOptions = new ArrayList<Integer>();

		_canadaTravelOptions.add(7);
		_canadaTravelOptions.add(9);
		_canadaTravelOptions.add(13);
		_canadaTravelOptions.add(16);
		_canadaTravelOptions.add(18);

	}
	
	private int getJourneyPrice(int days, int pricePerDay, int planeTicketPrice) {
		return days * pricePerDay + planeTicketPrice;
	}
	
	private int getJourneyPrice(int days) {
		return getJourneyPrice(days, _canadaPricePerDay, _canadaPlaneTicketPrice);
	}
	
	private void displayTravelInformation() {
		System.out.println("Available options to travel to " + _LocationName + " are following :");

		for (int days : _canadaTravelOptions) {
			int canadaStayingCost;
			canadaStayingCost = getJourneyPrice(days);
			System.out.println("Staying " + days + " days will cost you " + canadaStayingCost + "\u20ac!");
		}

		System.out.println("We hope you will find the option that suits you!");
	}
	
	@Override
	protected void execute(Scanner cin) {
		super.execute(cin);
		displayTravelInformation();
	}
}
