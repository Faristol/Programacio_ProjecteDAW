package com.project.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IniciarSessio {

	@SuppressWarnings("unused")
	public void iniciarSessio() throws IOException {
		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("-".repeat(14) + "Iniciar sessi�" + "-".repeat(15));
		System.out.println("-".repeat(43));
		String nom = introduirNomContrassenya();
//		String nom = nom();
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
		Usuari.carregarArrayListPelisUsuari(infoUser[3], infoUser[2]);
		Usuari.carregarArrayListActorsUsuari(infoUser[3], infoUser[2]);
		Usuari.carregarArrayListDirectorsUsuari(infoUser[3], infoUser[2]);
		menu(infoUser);
	}

//	public String nom () {
//		int i;
//		String contrassenyaNom;
//		do {
//			contrassenyaNom=contrassenyaNom();
//			 i = comprovacioContra(contrassenyaNom);
//		}while(i==0);
//		String[] aux = contrassenyaNom.split("_");
//		return aux[1];
//	}
//
//	public String contrassenyaNom() {
//		try (Scanner entrada = new Scanner(System.in)) {
//			String nom = null;
//			String contrassenya = null;
//			String contrassenyaNom = null;
//			System.out.println("Introdueix el teu nom:");
//				nom = entrada.nextLine().trim();
//				System.out.println("Introdueix la teua contrassenya:");
//				contrassenya = entrada.nextLine().trim();
//				contrassenyaNom = contrassenya.concat("_").concat(nom);
//		
//		return contrassenyaNom;
//		}
//	}
//	public int comprovacioContra(String contrassenyaNom) {
//		int i = 0;
//		File f = new File("contrassenyesUsuaris.txt");
//		try (Scanner lectorFitxer = new Scanner(f)) {
//			while (lectorFitxer.hasNextLine()) {
//				String contraUser = lectorFitxer.nextLine().trim();
//				if (contrassenyaNom.equals(contraUser)) {
//					i = 1;
//					break;
//				}
//			}
//			if (i == 0) {
//				System.err.println("Usuari o contrassenya incorrectes. Prova de nou:");
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return i;
//	}

	@SuppressWarnings("resource")
	public String introduirNomContrassenya() {
		Scanner entrada = new Scanner(System.in);
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

			try {
				Scanner lectorFitxer = new Scanner(f);
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

	public static String[] infoUser(String nom) {
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
		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("�s un plaer veure't per ac� " + nom + " " + cognom);

	}
//	public void menuAccio(){
//		 try (Scanner entrada = new Scanner(System.in)) {
//			System.out.println();
//			System.out.println("-".repeat(43));
//			System.out.println("Qu� desitja fer?");
//			System.out.println("-".repeat(43));
//			System.out.println("1.Accedir a les llistes generals");
//			System.out.println("2.Accedir a les teues llistes");
//			System.out.println("3.Fer enrere");
//			System.out.println("-".repeat(43));
//			
//
//			boolean troba = false;
//			int j = 0;
//			while(!entrada.hasNextLine()) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			entrada.nextLine();
//			do {
//
//				if(!entrada.hasNextInt()) {
//					System.out.println("Has d'introduir un nombre enter");
//				}
//				j = entrada.nextInt();
//				if (j == 1 || j == 2) {
//					troba = true;
//				} else {
//					System.out.println("Has de polsar 1 per a veurer les llistes generals, 2 per a veurer les teues llistes o 3 per a fer enrere.");
//				}
//				entrada.nextLine();
//			} while (!troba);
//		}

	public void menu(String infoUser[]) throws IOException {
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
					try {
						LlistesGenerals llistesGenerals = new LlistesGenerals();
						llistesGenerals.agregarElementoGeneralActor();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					menu(infoUser);
				} else if (fer == 2) {
					LlistesGenerals llistesGenerals = new LlistesGenerals();
					llistesGenerals.consultarActorGeneral();
					menu(infoUser);
				} else {
					menu(infoUser);
				}
				break;
			case 2:
				if (fer == 1) {
					try {
						LlistesGenerals llistesGenerals = new LlistesGenerals();
						llistesGenerals.agregarElementoGeneralPeli();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					menu(infoUser);
				} else if (fer == 2) {
					LlistesGenerals llistesGenerals = new LlistesGenerals();
					
					llistesGenerals.consultarPeliGeneral();
					menu(infoUser);
				} else {
					menu(infoUser);
				}
				break;
			case 3:
				if (fer == 1) {
					
					try {
						LlistesGenerals llistesGenerals = new LlistesGenerals();
						llistesGenerals.agregarElementoGeneralDirec();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					menu(infoUser);

				} else if (fer == 2) {
					LlistesGenerals llistesGenerals = new LlistesGenerals();
					llistesGenerals.consultarDirectorGeneral();
					menu(infoUser);
				} else {
					menu(infoUser);
				}
				break;
			case 4:
				menu(infoUser);
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
					Usuari.afegirActor(infoUser[3], infoUser[0]);
					menu(infoUser);
				} else if (fer == 2) {
					Usuari.consultarActor(infoUser[3], infoUser[0]);
					menu(infoUser);
				} else if (fer == 3) {
					// modificar
				} else if (fer == 4) {
					// eliminem

				} else {
					menu(infoUser);
				}
				break;
			case 2:
				if (fer == 1) {
					Usuari.afegirPeli(infoUser[3], infoUser[0]);
					menu(infoUser);
				} else if (fer == 2) {
					Usuari.consultarPeli(infoUser[3], infoUser[0]);
					menu(infoUser);
				} else if (fer == 3) {
					// modificar
				} else if (fer == 4) {
					// eliminem

				} else {
					menu(infoUser);

				}
				break;
			case 3:
				if (fer == 1) {
					Usuari.afegirDirector(infoUser[3], infoUser[0]);
					menu(infoUser);
				} else if (fer == 2) {
					Usuari.consultarDirector(infoUser[3], infoUser[0]);
					menu(infoUser);
				} else if (fer == 3) {
					// modificar
				} else if (fer == 4) {
					// eliminem

				} else {
					menu(infoUser);

				}
				break;
			case 4:
				menu(infoUser);
				break;
			default:
				System.out.println("Opción no válida. Intente nuevamente.");
				break;
			}

		} else {
			ProgramaPrincipal programaPrincipal = new ProgramaPrincipal();
			programaPrincipal.inici();
		}

	}
}
