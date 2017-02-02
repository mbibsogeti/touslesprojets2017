package fr.ib.obodrel.travel;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static TravelDestination _travelDestination;
	private static HashMap<String, Object> _travelOption;

	private static void initializeTravelOptions() {
		AlaskaTravelDestination Alaska = new AlaskaTravelDestination();
		CanadaTravelDestination Canada = new CanadaTravelDestination();
		SaskatchewanTravelDestination Saskatchewan = new SaskatchewanTravelDestination();
		WashingtonTravelDestination Washington = new WashingtonTravelDestination();
		NevadaTravelDestination Nevada = new NevadaTravelDestination();
		UnitedStatesTravelDestination UnitedStates = new UnitedStatesTravelDestination();
		TexasTravelDestination Texas = new TexasTravelDestination();

		_travelOption = new HashMap<String, Object>();
		_travelOption.put(Alaska.getDestinationID(), Alaska);
		_travelOption.put(Canada.getDestinationID(), Canada);
		_travelOption.put(UnitedStates.getDestinationID(), UnitedStates);
		_travelOption.put(Saskatchewan.getDestinationID(), Saskatchewan);
		_travelOption.put(Washington.getDestinationID(), Washington);
		_travelOption.put(Nevada.getDestinationID(), Nevada);
		_travelOption.put(Texas.getDestinationID(), Texas);
		_travelOption.put("q", null);
	}

	private static void chooseADestination(Scanner cin) {
		boolean hasChosenDestination = false;
		String line = null;

		System.out.println("Hi! Welcome to our reservation page, please chose where you will go to  :");
		line = "Type ";
		for (int i = 0; i < _travelOption.size(); i++) {
			if (_travelOption.keySet().toArray()[i].equals("q")) {
				continue;
			}
			line += "\"" + _travelOption.keySet().toArray()[i];
			line += "\" for ";
			line += ((TravelDestination) _travelOption.values().toArray()[i])._DestinationName;
			line += ", ";
		}
		line += " or q to quit.";
		System.out.println(line);
		line = null;

		while (!hasChosenDestination) {
			try {
				line = cin.nextLine();
				if (line.indexOf(" ") != -1) {
					line = (String) line.subSequence(0, line.indexOf(" "));
				}
				if (_travelOption.containsKey(line)) {
					_travelDestination = (TravelDestination) _travelOption.get(line);
					hasChosenDestination = true;
				} else {
					System.out.println("The Choice you made doesn't exist, please retry!\nEnter now :");
				}
			} catch (NoSuchElementException inputException) {
				System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
			} catch (IllegalStateException inputException) {
				System.out.println("You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
			}
		}
	}

	public static void main(String[] arg) {
		boolean wantToQuit = false;
		String line = null;
		Scanner cin = new Scanner(System.in);
		int numberEntered = -1;

		initializeTravelOptions();
		chooseADestination(cin);

		if (_travelDestination != null) {
			_travelDestination.execute(cin);
		} else {
			System.out.println("You chose to quit our software, thank you for trying us.");
		}

		while (!wantToQuit) {
			System.out.println("What will you do next ?\n" + "Type \"l\" to change your location,"
					+ " \"a\" to add duration, \"d\" to change the duration"
					+ ", \"p\" to print your choice, \"e\" to display informations,"
					+ " \"t\" to change mean of transport and \"q\" to quit.");
			try {
				line = cin.nextLine();
				switch (line) {
				case "l":
					System.out.println("Please type the location you want to go to :");
					try {
						line = cin.nextLine();
						_travelDestination.setLocationName(line);
					} catch (NoSuchElementException inputException) {
						System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
					} catch (IllegalStateException inputException) {
						System.out.println(
								"You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
					}
					break;
				case "a":
					numberEntered = -1;
					System.out.println("Please type the duration you want to add :");
					while (numberEntered < 0) {
						try {
							line = cin.nextLine();
							if (line.indexOf(" ") != -1) {
								line = (String) line.subSequence(0, line.indexOf(" "));
							}
							try {
								numberEntered = Integer.parseInt(line);
								if (numberEntered > 0) {
									_travelDestination.addTravelDuration(numberEntered);
								} else {
									System.out.println("You made a mistake you should provide a nuber higher than zero,"
											+ " please retry!\nEnter now :");
								}
							} catch (NumberFormatException inputException) {
								System.out.println(
										"You made a mistake this was not an Integer, please retry!\nEnter now :");
							}
						} catch (NoSuchElementException inputException) {
							System.out.println(
									"You made a mistake there was nothing entered, please retry!\nEnter now :");
						} catch (IllegalStateException inputException) {
							System.out.println(
									"You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
						}
					}
					break;
				case "d":
					numberEntered = -1;
					System.out.println("Please type the duration you want to stay :");
					while (numberEntered < 0) {
						try {
							line = cin.nextLine();
							if (line.indexOf(" ") != -1) {
								line = (String) line.subSequence(0, line.indexOf(" "));
							}
							try {
								numberEntered = Integer.parseInt(line);
								if (numberEntered > 0) {
									_travelDestination.setTravelDuration(numberEntered);
								} else {
									System.out.println("You made a mistake you should provide a nuber higher than zero,"
											+ " please retry!\nEnter now :");
								}
							} catch (NumberFormatException inputException) {
								System.out.println(
										"You made a mistake this was not an Integer, please retry!\nEnter now :");
							}
						} catch (NoSuchElementException inputException) {
							System.out.println(
									"You made a mistake there was nothing entered, please retry!\nEnter now :");
						} catch (IllegalStateException inputException) {
							System.out.println(
									"You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
						}
					}
					break;
				case "p":
					System.out.println(_travelDestination.toString());
					break;
				case "e":
					_travelDestination.execute(cin);
					break;
				case "t":
					System.out.println("Please choose a new mean of transport!");
					_travelDestination.chooseMeanOfTransportation(cin);
					break;
				case "q":
					wantToQuit = true;
					System.out.println("You chose to quit our software, thank you for trying us.");
					break;
				}
			} catch (NoSuchElementException inputException) {
				System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
			} catch (IllegalStateException inputException) {
				System.out.println("You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
			}
		}

		cin.close();
	}
}
