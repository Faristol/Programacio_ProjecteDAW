package com.project.main;

import java.util.Scanner;

public class Accio {
	@SuppressWarnings("resource")
	public static int menuAccio() {
		Scanner entrada = new Scanner(System.in);
		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("Qué desitja fer?");
		System.out.println("-".repeat(43));
		System.out.println("1.Accedir a les llistes generals");
		System.out.println("2.Accedir a les teues llistes");
		System.out.println("3.Fer enrere");
		System.out.println("-".repeat(43));

		int troba = 0;
		int j = 0;

		do {

			if (!entrada.hasNextInt()) {
				System.out.println("Has d'introduir un nombre enter");
				entrada.nextLine();
			}
			j = entrada.nextInt();
			if (j == 1 || j == 2 || j == 3) {
				troba = 1;
			} else {
				System.out.println(
						"Has de polsar 1 per a veurer les llistes generals, 2 per a veurer les teues llistes o 3 per a fer enrere.");
			}
		} while (troba == 0);
		return j;

	}
}
