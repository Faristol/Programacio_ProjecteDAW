package com.project.main;

public class Admin extends Usuaris {
	private String nom = "admin";
	private String cognoms = "admin";
	private String correuElectronic = "admin@gmail.com";
	private String contrassenya = "eljefe";
	private String poblacio = "admin";
	private final String rol = "ROL_ADMIN";
	private String dataNaixement = "01/01/01";

	static {

	}

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

	public Admin() {
		// TODO Auto-generated constructor stub
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

}
