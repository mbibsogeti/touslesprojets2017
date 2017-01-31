package fr.ib.obodrel.travel;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	
	public static int FindDaysOfStaying() {
		int daysOfStaying = -1;
		int numberEntered = 0;
		String line = null;

		Scanner cin = new Scanner(System.in);
		
		System.out.println("Hi! Welcome to our reservation page, please enter how many days you will stay in Alaska :");

		while (daysOfStaying < 0) {
			try {
				line = cin.nextLine();
				if(line.indexOf(" ") != -1 ) {
					line = (String) line.subSequence(0,line.indexOf(" "));
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
				System.out.println("You made a mistake you couldn't entere anything yet, please retry!\nEnter now :");
			}
		}

		cin.close();
		
		return daysOfStaying;
	}
	
	public static void AnalyzeDaysOfStaying(int daysOfStaying)
	{
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
				flyCompany = "Alaska Airlines";
			}
			break;
		default:
			if (daysOfStaying < 8) {
				flyCompany = "Air France";
			} else {
				flyCompany = "Alaska Airlines";
			}
		}

		System.out.println("Regarding how long you will stay we recommend you to take " + flyCompany
				+ " planes to travel back and forth!");
		
		System.out.println("Here you will find the schedule of your staying :\n");
		for(int i=0;i<daysOfStaying;i++) {
			if(i== 0 || i == daysOfStaying-1) {
				System.out.println("Day "+ (i+1) +" Plane");
			} else if(i%4==0) {
				System.out.println("Day "+ (i+1) +" Royal Crab");
			}else {
				System.out.println("Day "+ (i+1) +" Fishing");
			}
		}
	}
	
	public static void ComputeAndDisplayTravelCostAndInforamtions(float paymentReductionPercent, int planeTicketPrice, int daysOfStaying, int pricePerDay) {
		float totalPriceSpent;
		String outputMessage;

		totalPriceSpent = (1 - paymentReductionPercent) * (planeTicketPrice + pricePerDay * daysOfStaying);
		outputMessage = "\nYour journey in Alaska will cost you ";
		outputMessage += totalPriceSpent + "\u20ac calculated as follow : \n";
		outputMessage += -100 * paymentReductionPercent + "% of a " + planeTicketPrice + "\u20ac plane ticket, ";
		outputMessage += "and also the " + daysOfStaying + " days at " + pricePerDay + "\u20ac each.\n";
		outputMessage += "We hope you will have a nice staying!";

		System.out.println(outputMessage);
	}
		
	public static void main(String[] arg) {
		float paymentReductionPercent = 0.2f;
		int planeTicketPrice = 860;
		int daysOfStaying = -1;
		int pricePerDay = 48;

		daysOfStaying = FindDaysOfStaying();
		
		AnalyzeDaysOfStaying(daysOfStaying);
		
		ComputeAndDisplayTravelCostAndInforamtions(paymentReductionPercent, planeTicketPrice, daysOfStaying, pricePerDay);

	}
}
