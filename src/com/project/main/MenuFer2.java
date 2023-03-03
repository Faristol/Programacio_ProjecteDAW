package com.project.main;
import java.util.Scanner;

public class MenuFer2 {
		
		@SuppressWarnings("resource")
		public static int menuFer(){
			
			System.out.println();
			System.out.println("-".repeat(43));
			System.out.println("Que vols fer?");
			System.out.println("-".repeat(43));
			System.out.println("1.Afegir");
			System.out.println("2.Modificar");
			System.out.println("3.Eliminar");
			System.out.println("4.Veurer");
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
				if (j == 1 || j == 2 || j==3 || j==4) {
					troba = true;
				} else {
					System.out.println("Has de polsar 1 per a afegir, 2 per a modificar, 3 per a eliminar, 4 per a veurer o 5 per a fer enrere.");
				}
			} while (!troba);
			return j;
		
		
	}
}
