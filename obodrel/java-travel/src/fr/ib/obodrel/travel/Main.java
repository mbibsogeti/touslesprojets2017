package fr.ib.obodrel.travel;

import java.io.BufferedReader;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
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
		LousianaTravelDestination Lousiana = new LousianaTravelDestination();

		_travelOption = new HashMap<String, Object>();
		_travelOption.put(Alaska.getDestinationID(), Alaska);
		_travelOption.put(Canada.getDestinationID(), Canada);
		_travelOption.put(UnitedStates.getDestinationID(), UnitedStates);
		_travelOption.put(Saskatchewan.getDestinationID(), Saskatchewan);
		_travelOption.put(Washington.getDestinationID(), Washington);
		_travelOption.put(Nevada.getDestinationID(), Nevada);
		_travelOption.put(Texas.getDestinationID(), Texas);
		_travelOption.put(Lousiana.getDestinationID(), Lousiana);
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
			if (i % 6 == 0 && i > 0) {
				line += "\n";
			}
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
			wantToQuit = true;
		}

		while (!wantToQuit) {
			System.out.println("What will you do next ?\n" + "Type \"l\" to change your location,"
					+ " \"a\" to add duration, \"d\" to change the duration, \"u\" to change your username, "
					+ ", \"p\" to print your choice\n, \"e\" to display informations, \"v\" to validate your command"
					+ " \"t\" to change mean of transport and \"q\" to quit.");
			try {
				line = cin.nextLine();
				switch (line) {
				case "l":
					_travelDestination.chooseLocation(cin);
					break;
				case "u":
					_travelDestination.chooseUsername(cin);
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
				case "v":
					wantToQuit = true;
					FileOutputStream csvCommandOutput = null;
					String tmpLine = "Your choice is made!\n";
					tmpLine += _travelDestination.getUserName() + " has bought a ";
					tmpLine += _travelDestination.getMeanOfTransport() + " ticket to ";
					tmpLine += _travelDestination.getDestinationName() + " in order to visit ";
					tmpLine += _travelDestination.getLocationName() + " for ";
					tmpLine += _travelDestination.getTravelDuration() + " days.\n";
					tmpLine += "Please choose a payment option on the website you will be redirected to!\n";
					tmpLine += "We hope you will have a nice journey there! Thanks you for using us!";
					try {
						csvCommandOutput = new FileOutputStream("./command.csv");
						try {
							csvCommandOutput.write(tmpLine.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
							System.out.println("You couldn't write in the file !");
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						System.out.println("The file has bugged out!");
					} finally {
						if (csvCommandOutput != null) {
							try {
								csvCommandOutput.close();
							} catch (IOException e) {
								e.printStackTrace();
								System.out.println("The could not be closed!");
							}
						}
					}
					System.out.println("Checking if the file has been correctly written! Output :");

					FileReader csvCommandCheck = null;
					try {
						csvCommandCheck = new FileReader("./command.csv");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						System.out.println("The file could not be read!");
					}
					if (csvCommandCheck != null) {
						BufferedReader csvBuffer = new BufferedReader(csvCommandCheck);
						tmpLine = "";
						String readLine = "";
						try {
							while ((readLine = csvBuffer.readLine() ) != null) {
								tmpLine += readLine+"\n";
							}
						} catch (IOException e) {
							e.printStackTrace();
							 System.out.println("could not read a line");
						}
					}
					System.out.println(tmpLine);
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
