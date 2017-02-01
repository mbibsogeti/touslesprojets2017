package fr.ib.obodrel.travel;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static TravelDestination _travelDestination;
	private static HashMap<String, Object> _travelOption;

	public static void initializeTravelOptions() {
		_travelOption = new HashMap<String, Object>();
		AlaskaTravelDestination Alaska = new AlaskaTravelDestination();
		_travelOption.put("a", Alaska);
		_travelOption.put("q", null);
		CanadaTravelDestination Canada = new CanadaTravelDestination();
		_travelOption.put("c", Canada);
		SaskatchewanTravelDestination Saskatchewan = new SaskatchewanTravelDestination();
		_travelOption.put("s", Saskatchewan);
	}

	public static void chooseADestination(Scanner cin) {
		boolean hasChosenDestination = false;
		String line = null;

		System.out.println("Hi! Welcome to our reservation page, please chose where you will go to  :");
		System.out.println("Type a for Alaska, c for Canada, s for Saskatchewan or q to quit.");

		while (!hasChosenDestination) {
			try {
				line = cin.nextLine();
				if (line.indexOf(" ") != -1) {
					line = (String) line.subSequence(0, line.indexOf(" "));
				}
				if (_travelOption.containsKey(line)) {
					if (!_travelOption.equals("q")) {
						_travelDestination = (TravelDestination) _travelOption.get(line);
					} else {
						_travelDestination = null;
					}
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
		Scanner cin = new Scanner(System.in);

		initializeTravelOptions();
		chooseADestination(cin);

		if (_travelDestination != null) {
			_travelDestination.execute(cin);
		} else {
			System.out.println("You chose to quit our software, thank you for trying us.");
		}
		cin.close();
	}
}
