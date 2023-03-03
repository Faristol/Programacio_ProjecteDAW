package com.project.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Registre {
	public void registre(Scanner entrada, File f) {
		System.out.println();
		System.out.println("-".repeat(43));
		System.out.println("-".repeat(17) + "Registre" + "-".repeat(18));
		System.out.println("-".repeat(43));

		String nom = comprovacioNom(entrada, f);
		String cognoms = comprovacioCognoms(entrada, f);
		String correu = comprovacioCorreu(entrada, f);
		String contrassenya = comprovacioContrassenya(entrada);
		String poblacio = comprovacioPoblacio(entrada);
		String dataNaixement = comprovacioDataNaixement(entrada);
		String rol = comprovacioRol(entrada);
		String id = obtencioId();
		// guardem la informaciï¿½ de l'usuari en el registre d'usuaris (infoUsuaris.txt)
		guardarInformacioUsuari(nom, cognoms, correu, contrassenya, poblacio, rol, dataNaixement, id);
		// guardar la contrassenya_usuari en contrassenyesUsuaris.txt
		guardarContrassenyaUsuari(contrassenya, nom);
		// ara creem l'objecte usuari i els seus fitxers aplicant el metode
		Usuari user = new Usuari(nom, cognoms, correu, contrassenya, poblacio, dataNaixement, id);
		user.creacioCarpetaFitxer();
		// inmediatament portem a l'usuari a iniciar sessiï¿½
		// ara s'hauran de guardar els arrays, aixï¿½ es crearan els fitxers on
		// s'aguardaran els arraylists
		//  aixï¿½ la primera vegada es carregaran
		Usuari.guardarArrayListPelisUsuari(user.getPelisUsuari(), id, correu);
		Usuari.guardarArrayListDirectorsUsuari(user.getDirectorsUsuari(), id, correu);
		Usuari.guardarArrayListActorsUsuari(user.getActorsUsuari(), id, correu);
		// inmediatament portem al menu
		ProgramaPrincipal inici = new ProgramaPrincipal();
		inici.menuIniciSessio();
		

	}

	public String comprovacioNom(Scanner entrada, File f) {

		boolean troba = false;
		String nom = "";
		// per a evitar desbordament de lï¿½nia i que no genere un salt de pï¿½gina fixem la
		// longitud en uns 30 per al nom i 40 pals cognoms, 60 pal correu, i 30 per a la
		// poblacio
		System.out.println("Introdueix el teu nom:");
		do {
			nom = entrada.nextLine().trim();
			if (nom.contains(";")) {
				System.out.println("No pots usar el símbol \";");
			} else if (nom.length() < 1 || nom.length() > 30) {
				System.out.println("La longitud del nom ha de tindre entre 1 i 20 caràcters. Torna a provar.");
			} else {
				int comptadorOcurrencies = 0;

				try {
					Scanner lectorFitxer = new Scanner(f);
					while (lectorFitxer.hasNextLine()) {
						String[] info = (lectorFitxer.nextLine()).split(";");
						if (info[0].equals(nom)) {
							comptadorOcurrencies++;
						}
					}
					if (comptadorOcurrencies == 0) {
						troba = true;
						lectorFitxer.close();
					} else {
						System.out.println("El nom introduï¿½t no estï¿½ disponible. Torna a provar.");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} while (!troba);
		return nom;

	}

	public String comprovacioCognoms(Scanner entrada, File f) {

		boolean troba = false;
		String cognom = null;
		System.out.println("Introdueix el teu cognom:");
		do {
			cognom = entrada.nextLine().trim();
			if (cognom.contains(";")) {
				System.out.println("No pots usar el sï¿½mbol \";");
			} else if (cognom.length() < 1 || cognom.length() > 40) {
				System.out.println("La longitud del cognom ha de tindre entre 1 i 40 carï¿½cters.");
			} else {
				int comptadorOcurrencies = 0;

				try {
					Scanner lectorFitxer = new Scanner(f);
					while (lectorFitxer.hasNextLine()) {
						String[] info = (lectorFitxer.nextLine()).split(";");
						if (info[1].equals(cognom)) {
							comptadorOcurrencies++;
						}
					}
					if (comptadorOcurrencies == 0) {
						troba = true;
						lectorFitxer.close();
					} else {
						System.out.println("El cognom introduï¿½t no estï¿½ disponible. Torna a provar.");
						comptadorOcurrencies = 0;
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} while (!troba);

		return cognom;
	}

	public String comprovacioCorreu(Scanner entrada, File f) {
		boolean troba = false;
		String correu = null;
		System.out.println("Introdueix el teu correu:");
		do {

			correu = entrada.nextLine().trim();
			boolean coincideix = Pattern.compile("[\\w-\\.]+@[\\w-]+\\.[\\w]{2,4}").matcher(correu).matches();
			if (coincideix == false) {
				System.out.println("El correu introduï¿½t no presenta un format vï¿½lid.");
			} else if (correu.length() > 60) {
				System.out.println("La longitud del correu no pot superar els 60 carï¿½cters.");
			} else {
				int comptadorOcurrencies = 0;

				try {
					Scanner lectorFitxer = new Scanner(f);
					while (lectorFitxer.hasNextLine()) {
						String[] info = (lectorFitxer.nextLine()).split(";");
						if (info[2].equals(correu)) {
							comptadorOcurrencies++;
						}
					}
					if (comptadorOcurrencies == 0) {
						lectorFitxer.close();
						troba = true;
					} else {
						System.out.println("El correu introduï¿½t no estï¿½ disponible. Torna a provar.");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} while (!troba);
		return correu;
	}

	public String comprovacioContrassenya(Scanner entrada) {
		boolean troba = false;
		String contrassenya = null;
		do {
			System.out.println("Introdueix la contrassenya:");
			contrassenya = entrada.nextLine().trim();
			boolean valida = Pattern.compile("(?!.*;)[\\w!@#$%^&*()-+=]{6,20}").matcher(contrassenya).matches();
			if (valida == false) {
				System.out.println("La contrassenya ha de tindre entre 6 i 20 carï¿½cters. No pots usar el sï¿½mbol \";");
			} else {
				System.out.println("Torna a introduir la contrassenya:");
				String contrassenyaVerificacio = entrada.nextLine().trim();
				if (!contrassenya.equals(contrassenyaVerificacio)) {
					System.out.println("Les contrasenyes no coincideixen. Torna a intentar-ho.");
				} else {
					troba = true;
				}

			}
		} while (!troba);

		return contrassenya;
	}

	public String comprovacioPoblacio(Scanner entrada) {
		boolean troba = false;
		String poblacio = null;
		do {
			System.out.println("Introdueix la poblaciï¿½");
			poblacio = entrada.nextLine().trim();
			boolean valida = Pattern.compile("(?iu)[a-zï¿½-ï¿½\\s]+").matcher(poblacio).matches();
			if (valida == false) {
				System.out.println("Poblaciï¿½ no vï¿½lida");
			} else if (poblacio.length() < 0 || poblacio.length() > 30) {
				System.out.println("La longitud de la poblacio no pot superar els 30 carï¿½cters.");
			} else {
				troba = true;
			}
		} while (!troba);
		return poblacio;
	}

	public String comprovacioDataNaixement(Scanner entrada) {
		boolean troba = false;
		String dataNaixement = null;
		do {
			System.out.println("Introdueix la teua data de naixement:");
			dataNaixement = entrada.next().trim();
			boolean valida = Pattern.compile("([0-2][1-9]|[1-9]0|3[0-1])/(0[1-9]|1[0-2])/((19|20)\\d{2})")
					.matcher(dataNaixement).matches();
			if (valida == false) {
				System.out.println("Data de naixement en format invï¿½lid. El format ha de ser dd/mm/aaaa");
			} else {
				troba = true;
			}

		} while (!troba);

		return dataNaixement;
	}

	public String comprovacioRol(Scanner entrada) {
		String rol = null;
		do {
			System.out.println("Introdueix el rol:");
			rol = entrada.next();
			if (rol.equals("ROL_ADMIN")) {
				System.out.println("El rol ha de ser: ROL_USUARI");
			}

		} while (!rol.equals("ROL_USUARI"));
		return rol;
	}

	public String obtencioId() {
		File f = new File("infoUsuaris.txt");
		Scanner lectorFitxer;
		int aux = 0;
		try {
			lectorFitxer = new Scanner(f);
			// ometem les dades de la primera linia amb lectorFitxer.nextLine()
			lectorFitxer.nextLine();
			while (lectorFitxer.hasNextLine()) {
				String[] info = (lectorFitxer.nextLine()).split(";");
				if (Integer.valueOf(info[7]) > aux) {
					aux = Integer.valueOf(info[7]);
				}
			}
			lectorFitxer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id = String.valueOf(aux + 1);
		return id;

	}

	public void guardarInformacioUsuari(String nom, String cognoms, String correu, String contrassenya, String poblacio,
			String rol, String dataNaixement, String id) {
		String infoUsuari = nom.concat(";").concat(cognoms).concat(";").concat(correu).concat(";").concat(contrassenya)
				.concat(";").concat(poblacio).concat(";").concat(rol).concat(";").concat(dataNaixement).concat(";")
				.concat(id).concat(";");

		try {
			FileWriter fw = new FileWriter("infoUsuaris.txt", true);// true per a q escriga al final del fitxer
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(infoUsuari.concat("\n"));
			bw.flush();// escrivim al fitxer
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void guardarContrassenyaUsuari(String contrassenya, String nom) {
		String contrassenyaNom = contrassenya.concat("_").concat(nom);
		try {
			FileWriter fw = new FileWriter("contrassenyesUsuaris.txt", true);// true per a q escriga al final del fitxer
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contrassenyaNom.concat("\n"));
			bw.flush();// escrivim al fitxer
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
