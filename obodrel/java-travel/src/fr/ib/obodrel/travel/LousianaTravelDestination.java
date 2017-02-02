package fr.ib.obodrel.travel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LousianaTravelDestination extends UnitedStatesTravelDestination {

	public LousianaTravelDestination() {
		super();
		_DestinationName = "Lousiana";
		_travelDuration = 8;
		_DestinationId = "l";
	}
	
	protected void chooseLocation(Scanner cin) {
		String line = "";
		System.out.println("Since Lousiana is a special destination, we want you to confirm what place you will visit!");
		try {
			int i = 0;
			line = cin.nextLine();
			while (line.startsWith(" ", i++)) {
			}
			int j = 1;
			while (line.charAt(line.length() - j++) == ' ') {
			}
			line = line.substring(i - 1, line.length() - j + 2);
			line = line.substring(0, 1).toUpperCase() + line.substring(1);
			setLocationName(line);
		} catch (NoSuchElementException inputException) {
			System.out.println("You made a mistake there was nothing entered, please retry!\nEnter now :");
		} catch (IllegalStateException inputException) {
			System.out.println("You made a mistake you couldn't enter anything yet, please retry!\nEnter now :");
		}
	}


	protected void execute(Scanner cin) {
		LocalDateTime timeBeforeTravelStart;
		DateTimeFormatter timeFormat;
		System.out.println("Please choose the correct username and location to validate your travel!");
		chooseUsername(cin);
		chooseLocation(cin);
		timeBeforeTravelStart = LocalDateTime.now().plusWeeks(7).plusDays(5);
		timeFormat = DateTimeFormatter.ofPattern("dd/MM");
		System.out.println("Warning, due to organizations issues, we wont we able to make you go before "
				+ timeBeforeTravelStart.format(timeFormat) + "! We hope you will understand.");
		toString();
	}

}
