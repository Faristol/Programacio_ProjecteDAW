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
		System.out.println("2.Llista películ·les");
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
			if (j == 1 || j == 2 || j==3) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a actors, 2 per a películ·les, 3 per a directors o 4 per a fer enrere.");
			}
		} while (!troba);
		return j;
	}
	
}
