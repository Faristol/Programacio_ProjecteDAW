package com.project.main;

import java.io.Serializable;

public class Pelis implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titolPeli=null;
	private String generePeli=null;
	private String dataPublicacio = null;
	public String getTitolPeli() {
		return titolPeli;
	}
	public void setTitolPeli(String titolPeli) {
		this.titolPeli = titolPeli;
	}
	public String getGenerePeli() {
		return generePeli;
	}
	public void setGenerePeli(String generePeli) {
		this.generePeli = generePeli;
	}
	public String getDataPublicacio() {
		return dataPublicacio;
	}
	public void setDataPublicacio(String dataPublicacio) {
		this.dataPublicacio = dataPublicacio;
	}
	public Pelis(String titolPeli, String generePeli, String dataPublicacio) {
		super();
		this.titolPeli = titolPeli;
		this.generePeli = generePeli;
		this.dataPublicacio = dataPublicacio;
	}
	
	

	
}
