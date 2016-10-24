/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexions;

import IConsole.ES;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author alain
 */
public class ConnexionFichier <TypeStructure>{
	
	private String nomPhysique;

	public ConnexionFichier(String nomPhysique) {
		this.nomPhysique = nomPhysique;
	}
	
	public TypeStructure lire(){
		TypeStructure tab = null;
		try{
			FileInputStream fis = new FileInputStream(nomPhysique);
			ObjectInputStream ois = new ObjectInputStream(fis);
			tab=(TypeStructure)(ois.readObject());
		}
		catch(FileNotFoundException e){
			ES.affiche("Fichier nouveau\n");
		}
		catch(IOException e){
			ES.affiche("Problème de lecture du fichier\n");			
		}
		catch(ClassNotFoundException e){
			ES.affiche("Objet non conforme\n");			
		}
		return tab;
	}
	
	public void ecrire (TypeStructure tab){
		try{
			FileOutputStream fos = new FileOutputStream(nomPhysique);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(tab);
		}
		catch(FileNotFoundException e){
			ES.affiche("Problème d'ouverture");
		} catch (IOException e) {
			ES.affiche("Problème d'écriture du fichier");	
		}
	}

}
