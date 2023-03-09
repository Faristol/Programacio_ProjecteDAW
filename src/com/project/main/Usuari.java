package com.project.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuari extends Usuaris {
	private String nom = null;
	private String cognoms = null;
	private String correuElectronic = null;
	private String contrassenya = null;
	private String poblacio = null;
	private String rol = null;
	private String dataNaixement = null;
	private String id = null;

	// vinculem classe Usuari amb les diferents classes usant arrayList
	private static ArrayList<Pelis> pelisUsuari= new ArrayList<>();;
	private static ArrayList<Actors> actorsUsuari= new ArrayList<>();;
	private static ArrayList<Directors> directorsUsuari= new ArrayList<>();;

	public String getRol() {
		return rol;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public String getCorreuElectronic() {
		return correuElectronic;
	}

	public void setCorreuElectronic(String correuElectronic) {
		this.correuElectronic = correuElectronic;
	}

	public String getContrassenya() {
		return contrassenya;
	}

	public void setContrassenya(String contrassenya) {
		this.contrassenya = contrassenya;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public String getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(String dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public ArrayList<Pelis> getPelisUsuari() {
		return pelisUsuari;
	}

	public void setPelisUsuari(ArrayList<Pelis> pelisUsuari) {
		this.pelisUsuari = pelisUsuari;
	}

	public ArrayList<Actors> getActorsUsuari() {
		return actorsUsuari;
	}

	public void setActorsUsuari(ArrayList<Actors> actorsUsuari) {
		this.actorsUsuari = actorsUsuari;
	}

	public ArrayList<Directors> getDirectorsUsuari() {
		return directorsUsuari;
	}

	public void setDirectorsUsuari(ArrayList<Directors> directorsUsuari) {
		this.directorsUsuari = directorsUsuari;
	}

	// public static aix�, quan l'usuari inicie sessi� no caldr� recuperar la
	// informaci� i crear un objecte per a aplicar el
	// metode public void, en static ens estalviem ixe pas, sols s'haura de
	// recuperar el id i el correuElectronic
	// per a accedir a la seua carpeta
	// directament per a clidarlos ser� ex Usuari.guardarArrayListPelis(.......);
	public static void guardarArrayListPelisUsuari(ArrayList<Pelis> pelis, String id, String correuElectronic) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))
							+ "/GuardarArrayListPelisUsuari.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(pelis); // guardem l'arraylist en bytes
			out.close();
			fileOut.close();
		} catch (Exception e) {
			System.err.println(e);

		}

	}

	public static void guardarArrayListActorsUsuari(ArrayList<Actors> actors, String id, String correuElectronic) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))
							+ "/GuardarArrayListActorsUsuari.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(actors); // guardem l'arraylist en bytes
			out.close();
			fileOut.close();
		} catch (Exception e) {
			System.err.println(e);

		}

	}

	public static void guardarArrayListDirectorsUsuari(ArrayList<Directors> directors, String id,
			String correuElectronic) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))
							+ "/GuardarArrayListDirectorsUsuari.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(directors); // guardem l'arraylist en bytes
			out.close();
			fileOut.close();
		} catch (Exception e) {
			System.err.println(e);

		}

	}

	// creem els metodes per a carregar els arrays
	public static ArrayList<Pelis> carregarArrayListPelisUsuari(String id, String correuElectronic) {
		try {
			FileInputStream fileIn = new FileInputStream(
					"carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))
							+ "/GuardarArrayListPelisUsuari.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			@SuppressWarnings("unchecked")
			ArrayList<Pelis> peli = (ArrayList<Pelis>) in.readObject();
			// s'ha fet un casting tmb
			// ara l'array peli es podr� gastar per a extraure informaci� o posar-ne
			in.close();
			fileIn.close();
			return peli;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;

	}

	public static ArrayList<Actors> carregarArrayListActorsUsuari(String id, String correuElectronic) {
		try {
			FileInputStream fileIn = new FileInputStream(
					"carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))
							+ "/GuardarArrayListActorsUsuari.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			@SuppressWarnings("unchecked")
			ArrayList<Actors> actors = (ArrayList<Actors>) in.readObject();
			in.close();
			fileIn.close();
			return actors;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;

	}

	public static ArrayList<Directors> carregarArrayListDirectorsUsuari(String id, String correuElectronic) {
		try {
			FileInputStream fileIn = new FileInputStream(
					"carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))
							+ "/GuardarArrayListDirectorsUsuari.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			@SuppressWarnings("unchecked")
			ArrayList<Directors> directors = (ArrayList<Directors>) in.readObject();
			in.close();
			fileIn.close();
			return directors;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;

	}
	// ja tinguem els metodes per a carregar i guardar els arrays lists particulars
	// ara els generals en LlistesGenerals
//
	@SuppressWarnings("resource")
	public static void afegirPeli(String id, String nom) throws IOException {
		try {
			System.out.println("Aquestes son les pelicul·les que hi han, quina vols afegir a la teua llista?");
			LlistesGenerals llistesGenerals = new LlistesGenerals();
			llistesGenerals.consultarPeliGeneral();
		
			Scanner entrada = new Scanner(System.in);
			int valorafegir = 0;
			boolean troba = false;
			do {
				System.out.println("Introdueix un nombre enter.");
				valorafegir = entrada.nextInt();
				if (!entrada.hasNextInt()) {
					System.out.println("Has d'introduïr un nombre enter.");
				} else if (valorafegir< 0 || valorafegir > pelisUsuari.size()) {
					System.out.println("El nombre no correspon a cap pelicul·la.");
				} else {
					troba = true;
				}
			} while(!troba);
			FileWriter fw = new FileWriter("carpetesUsuari/"+id+nom+"/llistaPelis.llista", true);
			fw.write(pelisUsuari.get(valorafegir) + "\n");
			fw.close();
		}catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo.");
		}
	}
//
//	@Override
//	public void modificarPeli() {
//		// TODO Auto-generated method stub
//	}
	public static void consultarPeli(String id, String nom) {
	try {
		Scanner scanner = new Scanner(new File("carpetesUsuaris/"+id+nom+"/llistaPelis.llista"));
		System.out.println("Llista de les pelicul·les de l'usuari "+nom+":");
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	} catch (FileNotFoundException e) {
		System.out.println("Error al leer el archivo.");
	}
}
//
//	@Override
//	public void eliminarPeli() {
//		// TODO Auto-generated method stub
//
//	}
//
	@SuppressWarnings("resource")
	public static void afegirActor(String id, String nom) throws IOException{
		try {
			System.out.println("Aquests son els actors que hi han, quin vols afegir a la teua llista?");
			LlistesGenerals llistesGenerals = new LlistesGenerals();
			llistesGenerals.consultarActorGeneral();
			Scanner entrada = new Scanner(System.in);
			int valorafegir = 0;
			boolean troba = false;
			
			do {
				System.out.println("Introdueix un nombre enter.");
				valorafegir = entrada.nextInt();
				if (!entrada.hasNextInt()) {
					System.out.println("Has d'introduïr un nombre enter.");
				} else if (valorafegir< 0 || valorafegir > actorsUsuari.size()) {
					System.out.println("El nombre no correspon a cap actor.");
				} else {
					troba = true;
				}
			} while(!troba);
			
			FileWriter fw = new FileWriter("carpetesUsuari/"+id+nom+"/llistaActors.llista", true);
			fw.write(actorsUsuari.get(valorafegir) + "\n");
			fw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo.");
		}
		
	}
//
//	@Override
//	public void modificarActor() {
//		// TODO Auto-generated method stub
//
//	}
//
	public static void consultarActor(String id, String nom){
		try {
			Scanner scanner = new Scanner(new File("carpetesUsuaris/"+id+nom+"/llistaActors.llista"));
			System.out.println("Llista dels actors de l'usuari "+nom+":");
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo.");
		}
	}
//
//	@Override
//	public void eliminarActor() {
//		// TODO Auto-generated method stub
//
//	}
//
	@SuppressWarnings("resource")
	public static void afegirDirector(String id, String nom) throws IOException {
		try {
			
			LlistesGenerals llistesGenerals = new LlistesGenerals();
			llistesGenerals.consultarDirectorGeneral();
			Scanner entrada = new Scanner(System.in);
			int valorafegir = 0;
			boolean troba = false;
			
			do {
				System.out.println("Introdueix un nombre enter.");
				valorafegir = entrada.nextInt();
				if (!entrada.hasNextInt()) {
					System.out.println("Has d'introduïr un nombre enter.");
				} else if (valorafegir< 0 || valorafegir > directorsUsuari.size()) {
					System.out.println("El nombre no correspon a cap director.");
				} else {
					troba = true;
				}
			} while(!troba);
			FileWriter fw = new FileWriter("carpetesUsuari/"+id+nom+"/llistaDirectors.llista", true);
			fw.write(directorsUsuari.get(valorafegir) + "\n");
			fw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo.");
		}
	}
//
//	@Override
//	public void modificarDirector() {
//		// TODO Auto-generated method stub
//
//	}
//
	public static void consultarDirector(String id, String nom) {
		try {
			Scanner scanner = new Scanner(new File("carpetesUsuaris/"+id+nom+"/llistaDirectors.llista"));
			System.out.println("Llista dels directors de l'usuari "+nom+":");
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo.");
		}
	}
	
//
//	@Override
//	public void eliminarDirector() {
//		// TODO Auto-generated method stub
//
//	}

	public void creacioCarpetaFitxer() {
		File carpetaUsuari = new File(
				"carpetesUsuaris/" + this.id + this.correuElectronic.substring(0, correuElectronic.indexOf("@")));
		carpetaUsuari.mkdir();
		File llistaPelis = new File(carpetaUsuari.getParent() + "/" + carpetaUsuari.getName() + "/llistaPelis.llista");
		try {
			llistaPelis.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File llistaActors = new File(
				carpetaUsuari.getParent() + "/" + carpetaUsuari.getName() + "/llistaActors.llista");
		try {
			llistaActors.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File llistaDirectors = new File(
				carpetaUsuari.getParent() + "/" + carpetaUsuari.getName() + "/llistaDirectors.llista");
		try {
			llistaDirectors.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//tamb� creem els arxius que tindran els arraylists
//		File arraylistPelis = new File(
//				carpetaUsuari.getParent() + "/" + carpetaUsuari.getName() + "/GuardarArrayListPelisUsuari.txt");
//		try {
//			arraylistPelis.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		File arraylistActors = new File(
//				carpetaUsuari.getParent() + "/" + carpetaUsuari.getName() + "/GuardarArrayListActorsUsuari.txt");
//		try {
//			arraylistActors.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		File arraylistDirectors = new File(
//				carpetaUsuari.getParent() + "/" + carpetaUsuari.getName() + "/GuardarArrayListDirectorsUsuari.txt");
//		try {
//			arraylistDirectors.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public Usuari(String nom, String cognoms, String correuElectronic, String contrassenya, String poblacio,
			String dataNaixement, String id) {
		super();
		this.nom = nom;
		this.cognoms = cognoms;
		this.correuElectronic = correuElectronic;
		this.contrassenya = contrassenya;
		this.poblacio = poblacio;
		this.dataNaixement = dataNaixement;
		this.id = id;
	}

}
