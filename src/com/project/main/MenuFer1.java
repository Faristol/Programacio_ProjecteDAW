package com.project.main;

import java.util.Scanner;

public class MenuFer1 {
	@SuppressWarnings("resource")
	public static int menuFer() {

		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("Que vols fer?");
		System.out.println("-".repeat(43));
		System.out.println("1.Afegir");
		System.out.println("2.Veurer");
		System.out.println("3.Fer enrere");
		System.out.println("-".repeat(43));
		Scanner accio = new Scanner(System.in);

		boolean troba = false;
		int j = 0;
		do {
			while (!accio.hasNextInt()) {
				System.out.println("Has d'introduir un nombre enter");
				accio.nextLine();
			}
			j = accio.nextInt();
			if (j == 1 || j == 2 || j == 3) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a afegir o 2 per a veurer o 3 per a fer enrere.");
			}
		} while (!troba);
		return j;

	}
}