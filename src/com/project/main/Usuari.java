package com.project.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
	private ArrayList<Pelis> pelisUsuari;
	private ArrayList<Actors> actorsUsuari;
	private ArrayList<Directors> directorsUsuari;

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

	// public static així, quan l'usuari inicie sessió no caldrà recuperar la
	// informació i crear un objecte per a aplicar el
	// metode public void, en static ens estalviem ixe pas, sols s'haura de
	// recuperar el id i el correuElectronic
	// per a accedir a la seua carpeta
	//directament per a clidarlos serà ex Usuari.guardarArrayListPelis(.......);
	public static void guardarArrayListPelisUsuari(ArrayList<Pelis> pelis, String id, String correuElectronic) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))+"/GuardarArrayListPelisUsuari.txt");
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
					"carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))+"/GuardarArrayListActorsUsuari.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(actors); // guardem l'arraylist en bytes
			out.close();
			fileOut.close();
		} catch (Exception e) {
			System.err.println(e);

		}

	}
	public static void guardarArrayListDirectorsUsuari(ArrayList<Directors> directors, String id, String correuElectronic) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))+"/GuardarArrayListDirectorsUsuari.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(directors); // guardem l'arraylist en bytes
			out.close();
			fileOut.close();
		} catch (Exception e) {
			System.err.println(e);

		}

	}
	//creem els metodes per a carregar els arrays
	public static ArrayList<Pelis> carregarArrayListPelisUsuari(String id, String correuElectronic){
		try {
			FileInputStream fileIn = new FileInputStream("carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))+"/GuardarArrayListPelisUsuari.txt");
		    ObjectInputStream in = new ObjectInputStream(fileIn);
		    @SuppressWarnings("unchecked")
			ArrayList<Pelis> peli = (ArrayList<Pelis>) in.readObject();
		//s'ha fet un casting tmb
		//ara l'array peli es podrà gastar per a extraure informació o posar-ne
		    in.close();
		    fileIn.close();
		    return peli;
		}catch(Exception e) {
		    System.err.println(e);
		}
		return null;
		
	}
	public static ArrayList<Actors> carregarArrayListActorsUsuari(String id, String correuElectronic){
		try {
			FileInputStream fileIn = new FileInputStream("carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))+"/GuardarArrayListActorsUsuari.txt");
		    ObjectInputStream in = new ObjectInputStream(fileIn);
		    @SuppressWarnings("unchecked")
			ArrayList<Actors> actors = (ArrayList<Actors>) in.readObject();
		    in.close();
		    fileIn.close();
		    return actors;
		}catch(Exception e) {
		    System.err.println(e);
		}
		return null;
		
	}
	public static ArrayList<Pelis> carregarArrayListDirectorsUsuari(String id, String correuElectronic){
		try {
			FileInputStream fileIn = new FileInputStream("carpetesUsuaris/" + id + correuElectronic.substring(0, correuElectronic.indexOf("@"))+"/GuardarArrayListDirectorsUsuari.txt");
		    ObjectInputStream in = new ObjectInputStream(fileIn);
		    @SuppressWarnings("unchecked")
			ArrayList<Pelis> directors = (ArrayList<Pelis>) in.readObject();
		    in.close();
		    fileIn.close();
		    return directors;
		}catch(Exception e) {
		    System.err.println(e);
		}
		return null;
		
	}
	//ja tinguem els metodes per a carregar i guardar els arrays lists particulars
	//ara els generals en LlistesGenerals
	
	

	@Override
	public void crearPeli() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarPeli() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarPeli() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPeli() {
		// TODO Auto-generated method stub

	}

	@Override
	public void crearActor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarActor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarActor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarActor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void crearDirector() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarDirector() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarDirector() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarDirector() {
		// TODO Auto-generated method stub

	}

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
