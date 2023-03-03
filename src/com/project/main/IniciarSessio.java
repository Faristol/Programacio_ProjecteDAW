package com.project.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IniciarSessio {

	@SuppressWarnings("unused")
	public void iniciarSessio() {
		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("-".repeat(14) + "Iniciar sessi�" + "-".repeat(15));
		System.out.println("-".repeat(43));
		String nom = introduirNomContrassenya();
		String[] infoUser = infoUser(nom);
		// en la info obtesa de l'usuari s'accedir� a la carpeta seua
		benvinguda(infoUser[0], infoUser[1]);
		// aci s'hauran de carregar els ArrayList amb Serialitzable
		ArrayList<Pelis> peli = Usuari.carregarArrayListPelisUsuari(infoUser[3], infoUser[2]);
		ArrayList<Directors> directors = Usuari.carregarArrayListDirectorsUsuari(infoUser[3], infoUser[2]);
		ArrayList<Actors> actors = Usuari.carregarArrayListActorsUsuari(infoUser[3], infoUser[2]);
		// i carregem els generals
		LlistesGenerals llistesGenerals = new LlistesGenerals();
		llistesGenerals.carregarArrayListPelisGeneral();
		llistesGenerals.carregarArrayListActorsGeneral();
		llistesGenerals.carregarArrayListDirectorsGeneral();


	}
	public String contrassenyaNom(){
		return null;
	}

	public String introduirNomContrassenya() {
		try (Scanner entrada = new Scanner(System.in)) {
			int i = 0;
			String nom = null;
			String contrassenya = null;
			String contrassenyaNom = null;
			File f = new File("contrassenyesUsuaris.txt");
			System.out.println("Introdueix el teu nom:");
			do {
				nom = entrada.nextLine().trim();
				System.out.println("Introdueix la teua contrassenya:");
				contrassenya = entrada.nextLine().trim();
				contrassenyaNom = contrassenya.concat("_").concat(nom);

				try (Scanner lectorFitxer = new Scanner(f)) {
					while (lectorFitxer.hasNextLine()) {
						String contraUser = lectorFitxer.nextLine().trim();
						if (contrassenyaNom.equals(contraUser)) {
							i = 1;
							break;
						}
					}
					if (i == 0) {
						System.err.println("Usuari o contrassenya incorrectes. Prova de nou:");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} while (i == 0);
			return nom;
		}
	}

	public String[] infoUser(String nom) {
		File f = new File("infoUsuaris.txt");
		String[] infoUser = null;
		try (Scanner llegir = new Scanner(f)) {
			infoUser = new String[4];
			while (llegir.hasNextLine()) {
				String[] infoUsers = (llegir.nextLine()).split(";");
				if (infoUsers[0].equals(nom)) {
					infoUser[0] = nom;
					infoUser[1] = infoUsers[1];
					infoUser[2] = infoUsers[2];
					infoUser[3] = infoUsers[7];
					break;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infoUser;
	}

	public void benvinguda(String nom, String cognom) {
		System.out.println("�s un plaer veure't per ac� " + nom + " " + cognom);
	}

}
