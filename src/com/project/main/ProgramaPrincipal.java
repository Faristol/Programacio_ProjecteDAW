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
		} else if (acces == 2) {
			IniciarSessio is = new IniciarSessio();
			is.iniciarSessio();
			menu();
		} else {
			eixir();
			System.out.println("Programa tancat.");
		}
	}

	public void menu() {
		int accio = Accio.menuAccio();
		int llista = 0;
		if (accio != 3) {
			llista = AccioLlista.menuLlist1();
		}
		if (accio == 1) {
			int fer = 0;
			if (llista != 4) {
				fer = MenuFer1.menuFer();
			}
			switch (llista) {
			case 1:
				if (fer == 1) {
					// afegim
				} else if (fer == 2) {
					LlistesGenerals.consultarActorGeneral();
					menu();
				} else {
					menu();
				}
				break;
			case 2:
				if (fer == 1) {
					// afegim
				} else if (fer == 2) {
					LlistesGenerals.consultarPeliGeneral();
					menu();
				} else {
					menu();
				}
				break;
			case 3:
				if (fer == 1) {
					// afegim
				} else if (fer == 2) {
					LlistesGenerals.consultarDirectorGeneral();
					menu();
				} else {
					menu();
				}
				break;
			case 4:
				menu();
				break;
			default:
				System.out.println("Opción no válida. Intente nuevamente.");
				break;
			}

		} else if (accio == 2) {
			int fer = 0;
			if (llista != 4) {
				fer = MenuFer3.menuFer();
			}
			switch (llista) {
			case 1:
				if (fer == 1) {
					// afegim
				} else if (fer == 2) {
					Usuari.consultarActor(null, null);
					menu();
				} else if (fer == 3) {
					// modificar
				} else if (fer == 4) {
					// eliminem

				} else {
					menu();
				}
				break;
			case 2:
				if (fer == 1) {
					// afegim
				} else if (fer == 2) {
					Usuari.consultarPeli(null, null);
					menu();
				} else if (fer == 3) {
					// modificar
				} else if (fer == 4) {
					// eliminem

				} else {
					menu();

				}
				break;
			case 3:
				if (fer == 1) {
					// afegim
				} else if (fer == 2) {
					Usuari.consultarDirector(null, null);
					menu();
				} else if (fer == 3) {
					// modificar
				} else if (fer == 4) {
					// eliminem

				} else {
					menu();

				}
				break;
			case 4:
				menu();
				break;
			default:
				System.out.println("Opción no válida. Intente nuevamente.");
				break;
			}

		} else {
			inici();
		}

	}

	@SuppressWarnings("resource")
	public void menuIniciSessio() {
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
				System.out.println("Has de polsar 1 per a registrar-te, 2 per a iniciar sessi� o 3 per a eixir.");
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
		System.out.println("Qu� desitja fer?");
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
			if (i == 1 || i == 2 || i == 3 || i == 3) {
				troba = true;
			} else {
				System.out.println("Has de polsar 1 per a registrar-te, 2 per a iniciar sessi� o 3 per a eixir.");
			}
		} while (!troba);
		return i;
	}

	public void eixir() {
		Scanner entrada = new Scanner(System.in);
		entrada.close();
	}

}
