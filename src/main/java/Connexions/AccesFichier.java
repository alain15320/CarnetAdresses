/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexions;

import IConsole.ES;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author alain
 */
public class AccesFichier {
	
	private String nomPhysique;
	private BufferedWriter bo;
	private BufferedReader bi;

	public AccesFichier(String nomPhysique) {
		this.nomPhysique = nomPhysique;
	}
	
	public String lire() throws IOException{
		String st = "";
		String ligne;
		try{
			FileReader fi = new FileReader(nomPhysique);
			bi = new BufferedReader(fi);
			while ((ligne = bi.readLine())!= null){
				st+=ligne+"\n";
			}	
			bi.close();
		}
		catch(FileNotFoundException e){
			ES.affiche("Fichier nouveau\n");
		}
		catch(IOException e){
			ES.affiche("Problème de lecture du fichier\n");			
		}
		//System.out.println(st);
		return st;
	}
	
	
	public void ecrire (String str){
		ES.affiche("str => "+str+"\n");
		ES.affiche(str.length()+"\n");
		try{
			FileWriter fo = new FileWriter(nomPhysique);
			BufferedWriter bo = new BufferedWriter(fo);
			bo.write(str, 0, str.length());
			//bo.newLine();
			bo.close();
		}
		catch(FileNotFoundException e){
			ES.affiche("Problème d'ouverture");
		} catch (IOException e) {
			ES.affiche("Problème d'écriture du fichier");	
		}
	}
	
	public void fermer(){
		try{
			bo.close();
			bi.close();			
		}
		catch (IOException e){
			ES.affiche("Problème d'écriture du fichier");			
		}
	}
	
	
	public ArrayList<String> lireArray() throws IOException{
		ArrayList<String> al = new ArrayList<String>();
		String ligne;
		try{
			FileReader fi = new FileReader(nomPhysique);
			bi = new BufferedReader(fi);
			while ((ligne = bi.readLine())!= null){
				al.add(ligne);
			}	
			bi.close();
		}
		catch(FileNotFoundException e){
			ES.affiche("Fichier nouveau\n");
		}
		catch(IOException e){
			ES.affiche("Problème de lecture du fichier\n");			
		}
		return al;
	}
	
	public void ecrireArray(ArrayList<String> alStr) {
		String str = "";
		for (int i = 0; i < alStr.size(); i++) {
			str += alStr.get(i)+"\n";
		}
		ecrire(str);
	}
	
	// Découper les données d'une ligne
	public String [] extraireDonnees(String tmp)  {
	if (tmp != null) {
		// Créer un outil qui découpe  la chaine passée en paramètre (premier paramètre)
		// en utilisant le point-virgule (second paramètre) pour séparer les mots
		StringTokenizer st = new StringTokenizer(tmp,";");
		int i=0;
		// Créer un tableau à la taille du nombre de mots à extraire
		String mot[] = new String[st.countTokens()];
		// Parcourir l'ensemble des mots à extraire
		while (st.hasMoreTokens()) {
			// Les mémoriser dans un tableau
			mot[i] = st.nextToken();
			i++;
		}
		// Retourner le tableau contenant les mots extraits
		return mot;
		}
		else return null;
	}
	
	public String concatenerDonnees(String [] strTab, String sep) {
		if (sep == null) {
			sep = ";";
		}
		String str = strTab[0];
		for (int i = 1; i<strTab.length; i++) {
			str += sep+strTab[i];
		}
		return str;
	}

	
}
