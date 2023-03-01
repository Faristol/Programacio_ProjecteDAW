package com.project.main;

import java.io.File;
import java.io.IOException;

public class Usuari extends Usuaris {
	private String nom = null;
	private String cognoms = null;
	private String correuElectronic = null;
	private String contrassenya = null;
	private String poblacio = null;
	private String rol = null;
	private String dataNaixement = null;
	private String id=null;
	

	
	

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
		File carpetaUsuari = new File("carpetesUsuaris/"+this.id+this.correuElectronic.substring(0,correuElectronic.indexOf("@")));
		carpetaUsuari.mkdir();
		File llistaPelis = new File(carpetaUsuari.getParent()+"/"+carpetaUsuari.getName()+"/llistaPelis.llista");
		try {
			llistaPelis.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File llistaActors = new File(carpetaUsuari.getParent()+"/"+carpetaUsuari.getName()+"/llistaActors.llista");
		try {
			llistaActors.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File llistaDirectors = new File(carpetaUsuari.getParent()+"/"+carpetaUsuari.getName()+"/llistaDirectors.llista");
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
