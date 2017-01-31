package fr.ib.nicolas.travel;

import java.util.Scanner;

public class voyage2 {

	public static void main(String[] args) {
		System.out.println("bienvenue");
		Scanner sc = new Scanner(System.in);

		System.out.println("menu:......");
		String menu = sc.next();
		if (menu.equals("a")) { // permet de tester une chaine de caractère

			System.out.println("alaska");

		}

		if (menu.equals("c"))

		{
			System.out.println("canada");
		}
	}
}
