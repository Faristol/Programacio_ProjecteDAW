package com.project.main;

import java.util.Scanner;

public class Accio {
	@SuppressWarnings("resource")
	public static int menuAccio(){
		
		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("Què desitja fer?");
		System.out.println("-".repeat(43));
		System.out.println("1.Veurer les llistes generals");
		System.out.println("2.Veurer les teues llistes");
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
			if (j == 1 || j == 2) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a veurer les llistes generals, 2 per a veurer les teues llistes o 3 per a fer enrere.");
			}
			accio.nextLine();
		} while (!troba);
		return j;
	}
}
