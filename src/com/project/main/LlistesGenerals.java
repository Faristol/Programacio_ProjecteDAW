package com.project.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


//crec q la implementaci� del Serializable en aquest cas no caldria, ja que les clases Pelis, Actors i Directors, ja l'incorporen
//i d'alguna manera s'hereta
public class LlistesGenerals implements Serializable {

	private static final long serialVersionUID = 1L;
	public static ArrayList<Pelis> pelisGenerals = new ArrayList<>();
	public static ArrayList<Actors> actorsGenerals = new ArrayList<>();
	public static ArrayList<Directors> directorsGenerals = new ArrayList<>();
	
	static {
		guardarArrayListPelisGeneral();
		guardarArrayListActorsGeneral();
		guardarArrayListDirectorsGeneral();
	}

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

	public static void guardarArrayListPelisGeneral() {
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

	public static void guardarArrayListActorsGeneral() {
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

	public static void guardarArrayListDirectorsGeneral() {
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


	public void consultarPeliGeneral() {
		carregarArrayListPelisGeneral();
			System.out.println("Llista de les pelicul·les:");

			for (Pelis peli : LlistesGenerals.pelisGenerals) {
	            System.out.println(peli.getTitolPeli()+" "+peli.getGenerePeli()+" "+peli.getDataPublicacio());
	        }
		}
	
	public void consultarActorGeneral(){
		carregarArrayListActorsGeneral();
		System.out.println("Llista dels actors:");

		for (Actors actor : LlistesGenerals.actorsGenerals) {
            System.out.println(actor.getNomActor()+" "+actor.getCognomsActor()+" "+actor.getDataNaixementActor());
        }
	}
	
	public void consultarDirectorGeneral() { 
		carregarArrayListDirectorsGeneral();
		System.out.println("Llista dels directors:");
		 for (Directors director : LlistesGenerals.directorsGenerals) {
	            System.out.println(director.getNomDirector()+" "+director.getCognomsDirector()+" "+director.getDataNaixementDirector());
	        }
	}
	
	@SuppressWarnings("resource")
	public void agregarElementoGeneralActor() throws IOException{
		
			System.out.println("Quin es el nom del actor que vols agregar:");
			Scanner cadena = new Scanner(System.in);
			String act=cadena.nextLine();
			System.out.println("Quin es el seu cognom:");
			String cog=cadena.nextLine();
			System.out.println("Quina es la seua data de naixement");
			String dat=cadena.nextLine();
			Actors actor = new Actors(act, cog, dat);
			actorsGenerals.add(actor);
			guardarArrayListActorsGeneral();
		
	}
	@SuppressWarnings("resource")
	public void agregarElementoGeneralDirec() throws IOException{
		
		System.out.println("Quin es el nom del director que vols agregar:");
		Scanner cadena = new Scanner(System.in);
		String dir=cadena.nextLine();
		System.out.println("Quin es el seu cognom:");
		String cog=cadena.nextLine();
		System.out.println("Quina es la seua data de naixement");
		String dat=cadena.nextLine();
			
			Directors directors = new Directors(dir, cog, dat);
			directorsGenerals.add(directors);
			guardarArrayListDirectorsGeneral();
	
	}
	
	@SuppressWarnings("resource")
	public void agregarElementoGeneralPeli() throws IOException{
				
			System.out.println("Qué peli vols agregar:");
			Scanner cadena = new Scanner(System.in);
			String pel=cadena.nextLine();
			System.out.println("Qué genere es?");
			String gen=cadena.nextLine();
			System.out.println("Quina es la seua data de publicacio");
			String dat=cadena.nextLine();
			Pelis pelicula = new Pelis(pel, gen, dat);
			pelisGenerals.add(pelicula);
			guardarArrayListPelisGeneral();
		
	}
}
