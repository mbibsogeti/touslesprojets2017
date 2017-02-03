package fr.ib.obodrel.travel;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Travel Destination is the main class that allows subclasses to use the same
 * function to execute code which is override depending on the destination. It
 * enables extensions and help to create easily new destinations. It uses the
 * Command Design Pattern.
 * 
 * @author Obodrel
 * @since 31-01-2017
 * @version 1.0.0
 */
public abstract class TravelDestination {
	/**
	 * BASE_TRAVEL_DURATION this is the common duration for a travel.
	 */
	public static final int BASE_TRAVEL_DURATION = 7;
	protected String _DestinationId;
	protected String _DestinationName;
	protected String _LocationName;
	protected int _travelDuration;
	protected boolean _hasExecutedOnce;
	protected DestinationMeanOfTransport _meanOfTransport;
	protected String _userName;
	protected String _userEmail;

	/**
	 * Constructor to Travel Destination, allows people to create a destination
	 * which is other from the one inherited.
	 * 
	 * @deprecated It's a abstract class, do not use, override it instead.
	 * @param destinationName
	 *            Name of the destination represented by the class.
	 * @author Obodrel
	 * @since 31-01-2017
	 * @version 1.0.0
	 */
	public TravelDestination(String destinationName) {
		_DestinationName = destinationName;
		_hasExecutedOnce = false;
	}

	/**
	 * Basic Constructor, the one already override is subclasses.
	 * 
	 * @author Obodrel
	 * @since 31-01-2017
	 * @version 1.0.0
	 */
	public TravelDestination() {
		_meanOfTransport = new DestinationMeanOfTransport();
		_hasExecutedOnce = false;
		_DestinationName = "";
	}

	/**
	 * Getter to Destination Name, destination is a country/region, location is
	 * a city
	 * 
	 * @return returns _DestinationName
	 * @author Obodrel
	 * @since 31-01-2017
	 * @version 1.0.0
	 */
	public String getDestinationName() {
		return _DestinationName;
	}

	/**
	 * Setter to Destination Name, destination is a country/region, location is
	 * a city
	 * 
	 * @param destinationName
	 *            set a new location
	 * @since 31-01-2017
	 * @author Obodrel
	 * @version 1.0.0
	 */
	public void setDestinationName(String destinationName) {
		_DestinationName = destinationName;
	}

	/**
	 * Setter to Location Name, destination is a country/region, location is a
	 * city
	 * 
	 * @param locationName
	 *            set a new location
	 * @author Obodrel
	 * @since 31-01-2017
	 * @version 1.0.0
	 */
	public void setLocationName(String locationName) {
		_LocationName = locationName;
	}

	/**
	 * Getter to Location Name, destination is a country/region, location is a
	 * city
	 * 
	 * @return returns _LocationName
	 * @author Obodrel
	 * @since 31-01-2017
	 * @version 1.0.0
	 */
	public String getLocationName() {
		return _LocationName;
	}

	/**
	 * Getter to Destination ID, short string representing the destination
	 * 
	 * @return returns _DestinationId
	 * @author Obodrel
	 * @since 31-01-2017
	 * @version 1.0.0
	 */
	public String getDestinationID() {
		return _DestinationId;
	}

	/**
	 * Getter to userName
	 * 
	 * @return returns _userName
	 * @author Obodrel
	 * @since 02-02-2017
	 * @version 1.0.0
	 */
	public String getUserName() {
		return _userName;
	}

	/**
	 * Setter to userName
	 * 
	 * @param userName
	 *            name of the user to change
	 * @author Obodrel
	 * @since 02-02-2017
	 * @version 1.0.0
	 */
	public void setUserName(String userName) {
		_userName = userName;
	}

	/**
	 * Getter to userEmail
	 * 
	 * @return returns _userEmail
	 * @author Obodrel
	 * @since 03-02-2017
	 * @version 1.0.0
	 */
	public String getUserEmail() {
		return _userEmail;
	}

	/**
	 * Setter to userEmail
	 * 
	 * @param userEmail
	 *            name of the user to change
	 * @author Obodrel
	 * @since 03-02-2017
	 * @version 1.0.0
	 */
	public void setUserEmail(String userEmail) {
		_userEmail = userEmail;
	}

	/**
	 * Getter to travel duration
	 * 
	 * @return returns _travelDuration
	 * @author Obodrel
	 * @since 01-02-2017
	 * @version 1.0.0
	 */
	public int getTravelDuration() {
		return _travelDuration;
	}

	/**
	 * Setter to travel duration
	 * 
	 * @param travelDuration
	 *            number of days
	 * @author Obodrel
	 * @since 01-02-2017
	 * @version 1.0.0
	 */
	public void setTravelDuration(int travelDuration) {
		_travelDuration = travelDuration;
	}

	/**
	 * Add duration to the travel
	 * 
	 * @param travelDurationAdded
	 *            number of days you add
	 * @author Obodrel
	 * @since 02-02-2017
	 * @version 1.0.0
	 */
	public void addTravelDuration(int travelDurationAdded) {
		_travelDuration += travelDurationAdded;
	}

	/**
	 * Getter to travel duration converted in weeks
	 * 
	 * @return returns a float which is a converted travel duration in weeks
	 * @author Obodrel
	 * @since 01-02-2017
	 * @version 1.0.0
	 */
	public float getTravelDurationWeeks() {
		return _travelDuration / 7f;
	}

	/**
	 * Getter to mean of transport
	 * 
	 * @return returns a string which says how the user will travel
	 * @author Obodrel
	 * @since 02-02-2017
	 * @version 1.0.0
	 */
	public String getMeanOfTransport() {
		return _meanOfTransport.getMeanOfTransport();
	}

	/**
	 * Create a string representing the object of the class
	 * 
	 * @return returns the string of the object
	 * @author Obodrel
	 * @since 01-02-2017
	 * @version 1.0.0
	 */
	public String toString() {
		return "You, " + _userName + ", set to go to " + _DestinationName + " in " + _LocationName + " for "
				+ _travelDuration + " days using a " + _meanOfTransport.getMeanOfTransport() + " to travel around.";
	}

	/**
	 * Function which allow the user to set the location of the travel duration
	 * 
	 * @param cin
	 *            Scanner which will register what the user types
	 * @author Obodrel
	 * @since 01-02-2017
	 * @version 1.0.0
	 */
	protected void chooseLocation(Scanner cin) {
		String line = "";
		System.out.println("Please type the city/location you want to visit!");
		try {
			line = cin.nextLine();
			line = line.trim();
			try {
				line = line.substring(0, 1).toUpperCase() + line.substring(1);
			} catch (IndexOutOfBoundsException inputException) {
				System.out.println("You made a mistake please retry!\nEnter now :");
				chooseLocation(cin);
				return;
			}
			setLocationName(line);
		} catch (NoSuchElementException inputException) {
			System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
		} catch (IllegalStateException inputException) {
			System.out.println("You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
		}
	}

	/**
	 * Function which allow the user toregister his naùme
	 * 
	 * @param cin
	 *            Scanner which will register what the user types
	 * @author Obodrel
	 * @since 01-02-2017
	 * @version 1.0.0
	 */
	protected void chooseUsername(Scanner cin) {
		String line = "";
		System.out.println("Please type your name!");
		try {
			line = cin.nextLine();
			if (line.length() <= 0) {
				System.out.println("You made a mistake there was nothing entered, please retry!");
				chooseUsername(cin);
				return;
			}
			setUserName(line.trim());
			System.out.println("You succefully registered as " + _userName);
		} catch (NoSuchElementException inputException) {
			System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
		} catch (IllegalStateException inputException) {
			System.out.println("You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
		}
	}

	/**
	 * Function which allow the user to register his email
	 * 
	 * @param cin
	 *            Scanner which will register what the user types
	 * @author Obodrel
	 * @since 02-02-2017
	 * @version 1.0.0
	 */
	protected void chooseUserEmail(Scanner cin) {
		String line = "";
		System.out.println("Please type your email!");
		try {
			line = cin.nextLine();
			if (line.length() <= 0) {
				System.out.println("You made a mistake there was nothing entered, please retry!");
				chooseUserEmail(cin);
				return;
			}
			setUserEmail(line.trim());
			System.out.println("You succefully registered your email as " + _userEmail);
		} catch (NoSuchElementException inputException) {
			System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
		} catch (IllegalStateException inputException) {
			System.out.println("You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
		}
	}
	/**
	 * Function which allows the user to choose between several means of
	 * transportation to reach the destination
	 * 
	 * @param cin
	 *            Scanner which will register what the user types
	 * @author Obodrel
	 * @since 01-02-2017
	 * @version 1.0.0
	 */
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

	/**
	 * Basic execute function which will be override in sub classes to allow
	 * different executions
	 * 
	 * @param cin
	 *            Scanner which will register what the user types
	 * @author Obodrel
	 * @since 01-02-2017
	 * @version 1.0.0
	 */
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
