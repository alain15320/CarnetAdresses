/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarnetModele;

import java.util.ArrayList;

/**
 *
 * @author alain
 */
public class TabPersonnes {
	
	private ArrayList<Personne> listePersonne;

	public TabPersonnes() {
		this.listePersonne = new ArrayList<>();
	}
	
	public TabPersonnes(ArrayList<Personne> listePersonne) {
		this.listePersonne = listePersonne;
	}

	public ArrayList<Personne> getListeContacts() {
		return listePersonne;
	}

	public void setListeContacts(ArrayList<Personne> listePersonne) {
		this.listePersonne = listePersonne;
	}
	
	public int taille(){
		return this.listePersonne.size();
	}

	@Override
	public String toString() {
		String st="";
        if (taille() == 0) {
            return "Liste vide";
        }
        for (Personne p : listePersonne) {
            st += p.toString() + "\n";
        }
        return st;
	}
	
    public void ajouter(Personne p) {
        listePersonne.add(p);
    }
	
    public void supprimer(int id) {
    	listePersonne.remove(id);
    }
    
    public void supprimer(Personne p) {
    	listePersonne.remove(p);
    }    
    
    public Personne retourner(Integer id) {
        for (int i = 0; i < taille(); i++) {
            if (listePersonne.get(i).getId() == id) {
                return listePersonne.get(i);
            }
        }
        return null;
    }	
	
	
}
