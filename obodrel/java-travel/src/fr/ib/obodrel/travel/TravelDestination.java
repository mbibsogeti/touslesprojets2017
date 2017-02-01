package fr.ib.obodrel.travel;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class TravelDestination {
	protected String _DestinationId;
	protected String _DestinationName;
	protected String _LocationName;
	protected int _travelDuration;
	protected boolean _hasExecutedOnce;
	protected DestinationMeanOfTransport _meanOfTransport;

	public TravelDestination(String destinationName) {
		_DestinationName = destinationName;
		_hasExecutedOnce = false;
	}

	public TravelDestination() {
		_meanOfTransport = new DestinationMeanOfTransport();
		_hasExecutedOnce = false;
		_DestinationName = "";
	}

	public String getDestinationName() {
		return _DestinationName;
	}

	public void setLocationName(String locationName) {
		_LocationName = locationName;
	}

	public String getLocationName() {
		return _LocationName;
	}

	public void setDestinationName(String destinationName) {
		_DestinationName = destinationName;
	}

	public String getDestinationID() {
		return _DestinationId;
	}

	public void setDestinationID(String DestinationId) {
		_DestinationId = DestinationId;
	}

	public int getTravelDuration() {
		return _travelDuration;
	}

	public void setTravelDuration(int travelDuration) {
		_travelDuration = travelDuration;
	}

	public float getTravelDurationWeeks() {
		return _travelDuration / 7f;
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

	protected void chooseMeanOfTransportation(Scanner cin) {
		String line = null;
		boolean doesMeanExist = false;

		while (!doesMeanExist) {
			try {
				System.out.println(_meanOfTransport.toString());
				line = cin.nextLine();
				doesMeanExist = _meanOfTransport.setMeanOfTransport(line);
				if (doesMeanExist) {
					System.out.println("You sucessfully chose to visit around " + _LocationName + " using a "
							+ _meanOfTransport.getMeanOfTransport());
				} else {
					System.out.println("You entered a wrong value, please retry!\nEnter now :");
				}
			} catch (NoSuchElementException inputException) {
				System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
			} catch (IllegalStateException inputException) {
				System.out.println("You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
			}
		}
	}

	@Override
	public String toString() {
		return "You set to go to " + _DestinationName + " in " + _LocationName + " for " + _travelDuration
				+ " days using a " + _meanOfTransport.getMeanOfTransport() + "to travel around.";
	}

	protected void execute(Scanner cin) {
		if (_hasExecutedOnce) {
			return;
		}
		chooseLocation(cin);
		chooseMeanOfTransportation(cin);
		System.out.println(_DestinationName + " chosen, precisely : " + _LocationName
				+ " we advise you to visit there for " + _travelDuration + " days in a row!");
		_hasExecutedOnce = true;
	}
}
