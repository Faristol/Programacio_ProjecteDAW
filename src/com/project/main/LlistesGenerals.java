package com.project.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

//crec q la implementació del Serializable en aquest cas no caldria, ja que les clases Pelis, Actors i Directors, ja l'incorporen
//i d'alguna manera s'hereta
public class LlistesGenerals implements Serializable {

	private static final long serialVersionUID = 1L;
	public static ArrayList<Pelis> pelisGenerals = new ArrayList<>();
	public static ArrayList<Actors> actorsGenerals = new ArrayList<>();
	public static ArrayList<Directors> directorsGenerals = new ArrayList<>();

	public static ArrayList<Pelis> getPelisGenerals() {
		return pelisGenerals;
	}

	public static void setPelisGenerals(ArrayList<Pelis> pelisGenerals) {
		LlistesGenerals.pelisGenerals = pelisGenerals;
	}

	public static ArrayList<Actors> getActorsGenerals() {
		return actorsGenerals;
	}

	public static void setActorsGenerals(ArrayList<Actors> actorsGenerals) {
		LlistesGenerals.actorsGenerals = actorsGenerals;
	}

	public static ArrayList<Directors> getDirectorsGenerals() {
		return directorsGenerals;
	}

	public static void setDirectorsGenerals(ArrayList<Directors> directorsGenerals) {
		LlistesGenerals.directorsGenerals = directorsGenerals;
	}

	public void guardarArrayListPelisGeneral() {
		try {
			FileOutputStream fos = new FileOutputStream("arrayListsGenerals/ArrayListGeneralPelis.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(LlistesGenerals.pelisGenerals);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void guardarArrayListActorsGeneral() {
		try {
			FileOutputStream fos = new FileOutputStream("arrayListsGenerals/ArrayListGeneralActors.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(LlistesGenerals.actorsGenerals);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void guardarArrayListDirectorsGeneral() {
		try {
			FileOutputStream fos = new FileOutputStream("arrayListsGenerals/ArrayListGeneralDirectors.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(LlistesGenerals.directorsGenerals);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	@SuppressWarnings("unchecked")
	public void carregarArrayListPelisGeneral() {
		try {
			FileInputStream fis = new FileInputStream("arrayListsGenerals/ArrayListGeneralPelis.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			LlistesGenerals.pelisGenerals = (ArrayList<Pelis>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	@SuppressWarnings("unchecked")
	public void carregarArrayListActorsGeneral() {
		try {
			FileInputStream fis = new FileInputStream("arrayListsGenerals/ArrayListGeneralActors.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			LlistesGenerals.actorsGenerals = (ArrayList<Actors>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	@SuppressWarnings("unchecked")
	public void carregarArrayListDirectorsGeneral() {
		try {
			FileInputStream fis = new FileInputStream("arrayListsGenerals/ArrayListGeneralDirectors.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			LlistesGenerals.directorsGenerals = (ArrayList<Directors>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
