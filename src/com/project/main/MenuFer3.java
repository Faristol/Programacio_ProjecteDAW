package com.project.main;

import java.util.Scanner;

public class MenuFer3 {
	@SuppressWarnings("resource")
	public static int menuFer() {

		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("Que vols fer?");
		System.out.println("-".repeat(43));
		System.out.println("1.Afegir");
		System.out.println("2.Veurer");
		System.out.println("3.Modificar");
		System.out.println("4.Eliminar");
		System.out.println("5.Fer enrere");
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
			if (j == 1 || j == 2 || j == 3 || j == 4 || j == 5) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a accedir afegir.");
				System.out.println("Has de polsar 2 per a accedir veure.");
				System.out.println("Has de polsar 3 per a accedir modificar.");
				System.out.println("Has de polsar 4 per a eliminar.");
				System.out.println("Has de polsar 5 per a retrocedir.");
				
			}
		} while (!troba);
		return j;

	}
}
