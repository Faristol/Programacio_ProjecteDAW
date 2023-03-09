package com.project.main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProgramaPrincipal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProgramaPrincipal programa = new ProgramaPrincipal();
		programa.inici();
	}

	public void inici() throws IOException {
		int acces = menuInici();
		if (acces == 1) {
			File f = new File("infoUsuaris.txt");
			Scanner entrada = new Scanner(System.in);
			Registre r = new Registre();
			r.registre(entrada, f);
		} else if (acces == 2) {
			IniciarSessio is = new IniciarSessio();
			is.iniciarSessio();
		} else {
			eixir();
			System.out.println("Programa tancat.");
		}
	}

	@SuppressWarnings("resource")
	public void menuIniciSessio() throws IOException {
		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("Qué desitja fer?");
		System.out.println("-".repeat(43));
		System.out.println("1.Registrar-se");
		System.out.println("2.Iniciar sessi�");
		System.out.println("3.Eixir del programa");
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
			if (i == 1 || i == 2 || i == 3) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a registrar-te, 2 per a iniciar sessió o 3 per a eixir.");
			}
		} while (!troba);
		if (i == 1) {
			Registre r = new Registre();
			File f = new File("infoUsuaris.txt");
			Scanner entrada = new Scanner(System.in);
			r.registre(entrada, f);
		} else if (i == 2) {
			IniciarSessio is = new IniciarSessio();
			is.iniciarSessio();
		} else {
			eixir();
		}

	}

	@SuppressWarnings("resource")
	public int menuInici() {
		System.out.println("-----------Benvingut a PeliMania-----------");
		System.out.println("Qué desitja fer?");
		System.out.println("-".repeat(43));
		System.out.println("1.Registrar-se");
		System.out.println("2.Iniciar sessió");
		System.out.println("3.Eixir del programa");
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
			if (i == 1 || i == 2 || i == 3 || i == 3) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a registrar-te, 2 per a iniciar sessió o 3 per a eixir.");
			}
		} while (!troba);
		return i;
	}

	public void eixir() {
		Scanner entrada = new Scanner(System.in);
		entrada.close();
	}

}
