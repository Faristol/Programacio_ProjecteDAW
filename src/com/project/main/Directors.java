package com.project.main;

import java.io.Serializable;

public class Directors implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomDirector = null;
	private String cognomsDirector = null;
	private String dataNaixementDirector = null;

	public String getNomDirector() {
		return nomDirector;
	}

	public void setNomDirector(String nomDirector) {
		this.nomDirector = nomDirector;
	}

	public String getCognomsDirector() {
		return cognomsDirector;
	}

	public void setCognomsDirector(String cognomsDirector) {
		this.cognomsDirector = cognomsDirector;
	}

	public String getDataNaixementDirector() {
		return dataNaixementDirector;
	}

	public void setDataNaixementDirector(String dataNaixementDirector) {
		this.dataNaixementDirector = dataNaixementDirector;
	}

	public Directors(String nomDirector, String cognomsDirector, String dataNaixementDirector) {
		super();
		this.nomDirector = nomDirector;
		this.cognomsDirector = cognomsDirector;
		this.dataNaixementDirector = dataNaixementDirector;
	}

	public static char[] getNom() {
		// TODO Auto-generated method stub
		return null;
	}

}
