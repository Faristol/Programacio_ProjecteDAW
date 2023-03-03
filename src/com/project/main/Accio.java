package com.project.main;

import java.util.Scanner;

public class Accio {
	@SuppressWarnings("resource")
	public void menuAccio(){
		 Scanner entrada = new Scanner(System.in);
		
		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("Què desitja fer?");
		System.out.println("-".repeat(43));
		System.out.println("1.Accedir a les llistes generals");
		System.out.println("2.Accedir a les teues llistes");
		System.out.println("3.Fer enrere");
		System.out.println("-".repeat(43));
		

		boolean troba = false;
		int j = 0;
		
		do {
	
			if(!entrada.hasNextInt()) {
				System.out.println("Has d'introduir un nombre enter");
			}
			j = entrada.nextInt();
			if (j == 1 || j == 2) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a veurer les llistes generals, 2 per a veurer les teues llistes o 3 per a fer enrere.");
			}
			entrada.nextLine();
		} while (!troba);

	}
}
