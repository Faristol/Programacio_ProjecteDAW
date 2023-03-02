package com.project.main;

import java.io.Serializable;

public class Actors implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomActor=null;
	private String cognomsActor=null;
	private String dataNaixementActor=null;
	public String getNomActor() {
		return nomActor;
	}
	public void setNomActor(String nomActor) {
		this.nomActor = nomActor;
	}
	public String getCognomsActor() {
		return cognomsActor;
	}
	public void setCognomsActor(String cognomsActor) {
		this.cognomsActor = cognomsActor;
	}
	public String getDataNaixementActor() {
		return dataNaixementActor;
	}
	public void setDataNaixementActor(String dataNaixementActor) {
		this.dataNaixementActor = dataNaixementActor;
	}
	public Actors(String nomActor, String cognomsActor, String dataNaixementActor) {
		super();
		this.nomActor = nomActor;
		this.cognomsActor = cognomsActor;
		this.dataNaixementActor = dataNaixementActor;
	}
	

}
