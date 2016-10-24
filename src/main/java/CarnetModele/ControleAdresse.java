package CarnetModele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connexions.AccesFichier;
import IConsole.ES;

public class ControleAdresse {
	
	public static TabPersonnes lirePersonnes(String fic){
		int id=0;
		TabPersonnes tp = new TabPersonnes();
		String[] info = new String[8];
		AccesFichier ac = new AccesFichier(fic);
		ArrayList<String> al = null;
		try {
			al = ac.lireArray();
		} catch (IOException ex) {
			Logger.getLogger(MainFenetre.class.getName()).log(Level.SEVERE, null, ex);
		}
		for (String st : al){
			id++;
			info = ac.extraireDonnees(st);
			Personne p = new Personne(id, info);
			tp.ajouter(p);
		}
		return tp;
	}
	
	public static void ecrirePersonnes(TabPersonnes tp, String fic) {
		AccesFichier ac = new AccesFichier(fic);
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<Personne> lp = tp.getListeContacts();
		String str;
		for (Personne p : lp) {
			str = ac.concatenerDonnees(p.getListeInfos(), null);
			al.add(str);
		}
		ac.ecrireArray(al);
	}

}
