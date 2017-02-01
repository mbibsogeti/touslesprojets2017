package fr.ib.obodrel.travel;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class TravelDestination {
	protected String _DestinationId;
	protected String _DestinationName;
	protected String _LocationName;
	protected int _travelDuration;
	protected boolean _hasExecutedOnce;

	public TravelDestination(String destinationName) {
		_DestinationName = destinationName;
		_hasExecutedOnce = false;
	}

	public TravelDestination() {
		_hasExecutedOnce = false;
		_DestinationName = "";
	}

	protected String getDestinationName() {
		return _DestinationName;
	}

	protected void setLocationName(String locationName) {
		_LocationName = locationName;
	}

	protected String getLocationName() {
		return _LocationName;
	}

	protected void setDestinationName(String destinationName) {
		_DestinationName = destinationName;
	}

	protected String getDestinationID() {
		return _DestinationId;
	}

	protected void setDestinationID(String DestinationId) {
		_DestinationId = DestinationId;
	}

	protected int getTravelDuration() {
		return _travelDuration;
	}

	protected void setTravelDuration(int travelDuration) {
		_travelDuration = travelDuration;
	}

	protected void chooseLocation(Scanner cin) {
		System.out.println("Please type the city/location you want to visit!");
		try {
			setLocationName(cin.nextLine());
		} catch (NoSuchElementException inputException) {
			System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
		} catch (IllegalStateException inputException) {
			System.out.println("You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
		}
	}

	@Override
	public String toString() {
		return "You set to go to " + _DestinationName + " in " + _LocationName + " for " + _travelDuration + " days.";
	}

	protected void execute(Scanner cin) {
		if (_hasExecutedOnce) {
			return;
		}
		chooseLocation(cin);
		System.out.println(_DestinationName + " chosen, precisely : " + _LocationName
				+ " we advise you to visit there for " + _travelDuration + " days in a row!");
		_hasExecutedOnce = true;
	}
}
