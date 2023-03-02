package com.project.main;

import java.io.File;
import java.util.Scanner;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgramaPrincipal programa = new ProgramaPrincipal();
		programa.inici();
	}

	public void inici() {
		int acces = menuInici();
		if (acces == 1) {
			File f = new File("infoUsuaris.txt");
			Scanner entrada = new Scanner(System.in);
			Registre r = new Registre();
			r.registre(entrada, f);
		} else {
			IniciarSessio is = new IniciarSessio();
			is.iniciarSessio();
		}
	}

	@SuppressWarnings("resource")
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
		return i;
	}

}
