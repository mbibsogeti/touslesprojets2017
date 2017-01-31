package fr.ib.obodrel.travel;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	private static String _travelDestination;
	private static HashMap<String, String> _travelOption;
	private static Scanner _cin;

	public static void InitializeTravelOptions() {
		_cin = new Scanner(System.in);
		_travelOption = new HashMap<String, String>();
		_travelOption.put("a", "Alaska");
		_travelOption.put("q", "Quit");
		_travelOption.put("c", "Canada");
	}

	public static void ChooseADestionation() {
		boolean hasChosenDestination = false;
		String line = null;

		System.out.println("Hi! Welcome to our reservation page, please chose where you will go to  :");
		System.out.println("Type a for Alaska, c for Canada or q to quit.");

		while (!hasChosenDestination) {
			try {
				line = _cin.nextLine();
				if (line.indexOf(" ") != -1) {
					line = (String) line.subSequence(0, line.indexOf(" "));
				}
				if (_travelOption.containsKey(line)) {
					_travelDestination = _travelOption.get(line);
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

	public static int FindAlaskaDaysOfStaying() {
		int daysOfStaying = -1;
		int numberEntered = 0;
		String line = null;

		System.out.println("Hi! Welcome to our reservation page, please enter how many days you will stay in "
				+ _travelDestination + " :");

		while (daysOfStaying < 0) {
			try {
				line = _cin.nextLine();
				if (line.indexOf(" ") != -1) {
					line = (String) line.subSequence(0, line.indexOf(" "));
				}
				try {
					numberEntered = Integer.parseInt(line);
					if (numberEntered > 0) {
						daysOfStaying = numberEntered;
					} else {
						System.out.println("You made a mistake you should provide a nuber higher than zero,"
								+ " please retry!\nEnter now :");
					}
				} catch (NumberFormatException inputException) {
					System.out.println("You made a mistake this was not an Integer, please retry!\nEnter now :");
				}
			} catch (NoSuchElementException inputException) {
				System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
			} catch (IllegalStateException inputException) {
				System.out.println("You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
			}
		}

		return daysOfStaying;
	}

	public static void AnalyzeAlaskaDaysOfStaying(int daysOfStaying) {
		String flyCompany = null;

		if (daysOfStaying < 8) {
			System.out.println("Sadly you will not visit us long");
		} else if (daysOfStaying < 15) {
			System.out.println(
					"That is a nice stay, we hope you wil enjoy it and we will give you a key toy as a present!");
		} else {
			System.out.println(
					"You will stay with us very long! We hope you wil enjoy it and we will give you a gold nugget as a present!");
		}

		switch (daysOfStaying % 7) {
		case 0:
			if (daysOfStaying / 7 < 5) {
				flyCompany = "Condor";
			} else {
				flyCompany = _travelDestination + " Airlines";
			}
			break;
		default:
			if (daysOfStaying < 8) {
				flyCompany = "Air France";
			} else {
				flyCompany = _travelDestination + " Airlines";
			}
		}

		System.out.println("Regarding how long you will stay we recommend you to take " + flyCompany
				+ " planes to travel back and forth!");

		System.out.println("Here you will find the schedule of your staying :\n");
		for (int i = 0; i < daysOfStaying; i++) {
			if (i == 0 || i == daysOfStaying - 1) {
				System.out.println("Day " + (i + 1) + " Plane");
			} else if (i % 4 == 0) {
				System.out.println("Day " + (i + 1) + " Royal Crab");
			} else {
				System.out.println("Day " + (i + 1) + " Fishing");
			}
		}
	}

	public static void ComputeAndDisplayAlaskaTravelCostAndInforamtions(float paymentReductionPercent,
			int planeTicketPrice, int daysOfStaying, int pricePerDay) {
		float totalPriceSpent;
		String outputMessage;

		totalPriceSpent = (1 - paymentReductionPercent) * (planeTicketPrice + pricePerDay * daysOfStaying);
		outputMessage = "\nYour journey in " + _travelDestination + " will cost you ";
		outputMessage += totalPriceSpent + "\u20ac calculated as follow : \n";
		outputMessage += -100 * paymentReductionPercent + "% of a " + planeTicketPrice + "\u20ac plane ticket, ";
		outputMessage += "and also the " + daysOfStaying + " days at " + pricePerDay + "\u20ac each.\n";
		outputMessage += "We hope you will have a nice staying!";

		System.out.println(outputMessage);
	}

	public static void DisplayCanadaTravelInformation() {
		ArrayList<Integer> CanadaTravelOptions;
		int canadaPricePerDay = 45;
		int canadaPlaneTicketPrice = 785;

		CanadaTravelOptions = new ArrayList<Integer>();

		CanadaTravelOptions.add(7);
		CanadaTravelOptions.add(9);
		CanadaTravelOptions.add(13);
		CanadaTravelOptions.add(16);
		CanadaTravelOptions.add(18);
		
		System.out.println("Available options to travel to " + _travelDestination + " are following :");

		for (int days : CanadaTravelOptions) {
			int canadaStayingCost;
			canadaStayingCost = days * canadaPricePerDay + canadaPlaneTicketPrice;
			System.out.println("Staying " + days + " days will cost you " + canadaStayingCost + "\u20ac!");
		}

		System.out.println("We hope you will find the option that suits you!");
	}

	public static void main(String[] arg) {
		float paymentReductionPercent = 0.2f;
		int planeTicketPrice = 860;
		int daysOfStaying = -1;
		int pricePerDay = 48;

		InitializeTravelOptions();
		ChooseADestionation();
		if (_travelDestination.equals("Alaska")) {
			daysOfStaying = FindAlaskaDaysOfStaying();

			AnalyzeAlaskaDaysOfStaying(daysOfStaying);

			ComputeAndDisplayAlaskaTravelCostAndInforamtions(paymentReductionPercent, planeTicketPrice, daysOfStaying,
					pricePerDay);
		} else if (_travelDestination.equals("Canada")) {
			DisplayCanadaTravelInformation();
		} else {
			System.out.println("You chose to quit our software, thank you for trying us.");
		}
		_cin.close();
	}
}
