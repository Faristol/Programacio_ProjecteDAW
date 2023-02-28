package com.project.main;

import java.util.Scanner;

public class ProgramaPrincipal {
	private int acces = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgramaPrincipal programa = new ProgramaPrincipal();
		programa.inici();
	}

	public void inici() {
		
		acces = menuInici();
		if (acces == 1) {
			registre();
		} else {
			iniciarSessio();
		}
	}

	public int menuInici() {
		System.out.println("-----------Benvingut a PeliMania-----------");
		System.out.println("Què desitja fer?");
		System.out.println("-".repeat(43));
		System.out.println("1.Registrar-se");
		System.out.println("2.Iniciar sessió");
		System.out.println("-".repeat(43));
		Scanner entradaInici = new Scanner(System.in);
		boolean troba = false;
		int i = 0;
		do {
			while (!entradaInici.hasNextInt()) {
				System.out.println("Has d'introduir un nombre enter");
				entradaInici.nextLine();
			}
			i = entradaInici.nextInt();
			if (i == 1 || i == 2) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a registrar-te o 2 per a iniciar sessió.");
			}
		} while (!troba);
		entradaInici.close();
		return acces;
	}

	public void registre() {

	}

	public void iniciarSessio() {

	}

}
