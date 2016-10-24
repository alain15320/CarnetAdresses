/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarnetModele;

/**
 *
 * @author alain
 */
public class Personne {
	
	private int id;
	private String [] listeInfos = new String[8];;
	private String prenom;
	private String nom;
	private String nomPhoto;
	private String telDom;
	private String telMob;
	private String email;
	private String adresse;
	private String ville;
	
	public Personne() {
		
	}

	public Personne(int id, String[] listeInfos) {
		this.id = id;
		//this.listeInfos = new String[listeInfos.length];
		this.listeInfos = listeInfos;
		this.prenom = listeInfos[0];
		this.nom = listeInfos[1];		
		this.nomPhoto = listeInfos[2];
		this.telDom = listeInfos[3];
		this.telMob = listeInfos[4];
		this.email = listeInfos[5];
		this.adresse = listeInfos[6];
		this.ville = listeInfos[7];		
	}

	public int getId() {
		return id;
	}

	public String[] getListeInfos() {
		return listeInfos;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public String getTelDom() {
		return telDom;
	}

	public String getTelMob() {
		return telMob;
	}

	public String getEmail() {
		return email;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setListeInfos(String[] listeInfos) {
		this.listeInfos = listeInfos;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
		this.listeInfos[0] = prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
		this.listeInfos[1] = nom;		
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
		this.listeInfos[2] = nomPhoto;
	}

	public void setTelDom(String telDom) {
		this.telDom = telDom;
		this.listeInfos[3] = telDom;
	}

	public void setTelMob(String telMob) {
		this.telMob = telMob;
		this.listeInfos[4] = telMob;
	}

	public void setEmail(String email) {
		this.email = email;
		this.listeInfos[5] = email;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
		this.listeInfos[6] = adresse;
	}

	public void setVille(String ville) {
		this.ville = ville;
		this.listeInfos[7] = ville;		
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", prenom : " + listeInfos[0] + ", nom : " + listeInfos[1] + ", photo : " + listeInfos[2];
	}

	
}
