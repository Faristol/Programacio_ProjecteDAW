package com.project.main;

import java.util.Scanner;

public class AccioLlista {

	@SuppressWarnings("resource")
	public static int menuLlist1(){
		
		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("A quina llista vols accedir?");
		System.out.println("-".repeat(43));
		System.out.println("1.Llista actors");
		System.out.println("2.Llista pelicul·les");
		System.out.println("3.llista directors");
		System.out.println("4.Fer enrere");
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
			if (j == 1 || j == 2 || j==3 || j==4) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a accedir a la llista pelicul·les.");
				System.out.println("Has de polsar 2 per a accedir a la llista actors.");
				System.out.println("Has de polsar 3 per a accedir a la llista directors.");
				System.out.println("Has de polsar 4 per a retrocedir.");
			}
		} while (!troba);
		return j;
	}
	
}