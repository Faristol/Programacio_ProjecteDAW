package com.project.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

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
			try {
				registre(entrada, f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return i;
	}

	public void registre(Scanner entrada, File f) throws FileNotFoundException {

		String nom = comprovacioNom(entrada, f);
		String cognoms = comprovacioCognoms(entrada, f);
		String correu = comprovacioCorreu(entrada, f);
		String contrassenya = comprovacioContrassenya(entrada);
		String poblacio = comprovacioPoblacio(entrada);
		String dataNaixement = comprovacioDataNaixement(entrada);
		String rol = comprovacioRol(entrada);
		String id = obtencioId();
		// guardem la informació de l'usuari en el registre d'usuaris (infoUsuaris.txt)
		guardarInformacioUsuari(nom, cognoms, correu, contrassenya, poblacio, rol, dataNaixement, id);
		// guardar la contrassenya_usuari en contrassenyesUsuaris.txt
		guardarContrassenyaUsuari(contrassenya, nom);
		// ara creem l'objecte usuari i així es crearan els seus fitxers automaticament

	}

	public String comprovacioNom(Scanner entrada, File f) throws FileNotFoundException {
		try (Scanner lectorFitxer = new Scanner(f)) {
			boolean troba = false;
			String nom = "";
			// per a evitar desbordament de línia i que no genere un salt de pàgina fixem la
			// longitud en uns 30 per al nom i 40 pals cognoms, 60 pal correu, i 30 per a la
			// poblacio

			do {
				System.out.println("Introdueix el teu nom:");
				nom = entrada.nextLine().trim();
				if (nom.contains(";")) {
					System.out.println("No pots usar el símbol \";");
				} else if (nom.length() < 1 || nom.length() > 30) {
					System.out.println("La longitud del nom ha de tindre entre 1 i 20 caràcters. Torna a provar.");
				} else {
					while (lectorFitxer.hasNextLine() && !troba) {
						String[] info = (lectorFitxer.nextLine()).split(";");
						if (info[0].equals(nom)) {
							System.out.println("El nom introduït no està disponible. Torna a provar.");
							break;
						} else {
							troba = true;
						}

					}
				}

			} while (!troba);
			lectorFitxer.close();
			return nom;
		}
	}

	public String comprovacioCognoms(Scanner entrada, File f) throws FileNotFoundException {

		try (Scanner lectorFitxer = new Scanner(f)) {
			boolean troba = false;
			String cognom = null;
			do {
				System.out.println("Introdueix el teu cognom:");
				cognom = entrada.nextLine().trim();
				if (cognom.contains(";")) {
					System.out.println("No pots usar el símbol \";");
				} else if (cognom.length() < 1 || cognom.length() > 40) {
					System.out.println("La longitud del cognom ha de tindre entre 1 i 40 caràcters.");
				} else {
					while (lectorFitxer.hasNextLine() && !troba) {
						String[] info = (lectorFitxer.nextLine()).split(";");
						if (info[1].equals(cognom)) {
							System.out.println("El cognom introduït no està disponible");
							break;
						} else {
							troba = true;
						}

					}
				}

			} while (!troba);
			lectorFitxer.close();
			return cognom;
		}
	}

	public String comprovacioCorreu(Scanner entrada, File f) throws FileNotFoundException {
		try (Scanner lectorFitxer = new Scanner(f)) {
			boolean troba = false;
			String correu = null;

			do {
				System.out.println("Introdueix el teu correu:");
				correu = entrada.nextLine().trim();
				boolean coincideix = Pattern.compile("^[\\w-\\.]+@[\\w-]+\\.[\\w]{2,4}$").matcher(correu).matches();
				if (coincideix == false) {
					System.out.println("El correu introduït no presenta un format vàlid.");
				} else if (correu.length() > 60) {
					System.out.println("La longitud del correu no pot superar els 60 caràcters.");
				} else {
					while (lectorFitxer.hasNextLine() && !troba) {
						String[] info = (lectorFitxer.nextLine()).split(";");
						if (info[2].equals(correu)) {
							System.out.println("El correu introduït no està disponible");
							break;
						} else {
							troba = true;
						}

					}

				}

			} while (!troba);
			lectorFitxer.close();
			return correu;
		}
	}

	public String comprovacioContrassenya(Scanner entrada) {
		boolean troba = false;
		String contrassenya = null;
		do {
			System.out.println("Introdueix la contrassenya:");
			contrassenya = entrada.nextLine().trim();
			boolean valida = Pattern.compile("^(?!.*;)[\\w!@#$%^&*()-+=]{6,20}$").matcher(contrassenya).matches();
			if (valida == false) {
				System.out.println("La contrassenya ha de tindre entre 6 i 20 caràcters. No pots usar el símbol \";");
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
			System.out.println("Introdueix la població");
			poblacio = entrada.nextLine().trim();
			boolean valida = Pattern.compile("^(?iu)[a-zà-ÿ\\s]+$").matcher(poblacio).matches();
			if (valida == false) {
				System.out.println("Població no vàlida");
			} else if (poblacio.length() < 0 || poblacio.length() > 30) {
				System.out.println("La longitud de la poblacio no pot superar els 30 caràcters.");
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
				System.out.println("Data de naixement en format invàlid. El format ha de ser dd/mm/aaaa");
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

	public String obtencioId() throws FileNotFoundException {
		File f = new File("infoUsuaris.txt");
		Scanner lectorFitxer = new Scanner(f);
		int aux = 0;
		// ometem les dades de la primera linia amb lectorFitxer.nextLine()
		lectorFitxer.nextLine();
		while (lectorFitxer.hasNextLine()) {
			String[] info = (lectorFitxer.nextLine()).split(";");
			if (Integer.valueOf(info[7]) > aux) {
				aux = Integer.valueOf(info[7]);
			}
		}
		lectorFitxer.close();
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
			bw.write(infoUsuari);
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
			bw.write(contrassenyaNom);
			bw.flush();// escrivim al fitxer
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void iniciarSessio() {

	}

}
