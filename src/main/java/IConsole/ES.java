/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IConsole;

import java.awt.Dimension;
import java.util.*;

/**
 *
 * @author alain
 */
public class ES {
    
    private static Scanner sc = new Scanner(System.in);

    public static void affiche(String mes){
        System.out.print(mes);
    }
    
    public static String saisie(String mes){
        affiche(mes);
        return sc.nextLine();
    }    
       
    public static int saisie(String mes, int inf, int sup){
        affiche(mes);
        int ent;
        do{
            try{
                ent=sc.nextInt();
                sc.nextLine();
                if (ent >=inf && ent<=sup){
                    return ent;
                }
                else{
                    affiche("Saisie hors intervalle réessayez\n");                    
                }
            }
            catch (InputMismatchException e)
            {
                affiche("Saisie non numérique, réessayez\n");
                sc.nextLine();
            }

        } while(true);
    }

    public static int saisie(String mes, int inf){
        affiche(mes);
        int ent;
        do{
            try{
                ent=sc.nextInt();
                sc.nextLine();
                if (ent>=inf) return ent;
                affiche("Saisie hors intervalle, réessayez\n");
            }
            catch (InputMismatchException e)
            {
                affiche("Saisie non numérique, réessayez\n");
                sc.nextLine();
            }

        } while(true);
    }

    public static float saisie(String mes, float inf, float sup){
        affiche(mes);
        float ent;
        do{
            try{
                ent=sc.nextFloat();
                sc.nextLine();
                if (ent >=inf && ent<=sup) return ent;
                affiche("Saisie hors intervalle, réessayez\n");
            }
            catch (InputMismatchException e)
            {
                affiche("Saisie non numérique, réessayez\n");
                sc.nextLine();
            }

        } while(true);
    }

    public static float saisie(String mes, float inf){
        affiche(mes);
        float ent;
        do{
            try{
                ent=sc.nextFloat();
                sc.nextLine();
                if (ent >=inf) return ent;
                affiche("Saisie hors intervalle, réessayez\n");
            }
            catch (InputMismatchException e)
            {
                affiche("Saisie non numérique, réessayez\n");
                sc.nextLine();
            }

        } while(true);
    }

	public static boolean saisieOuiNon(String mes){
		try{
		char rep=saisie(mes).charAt(0);
		return(rep=='O'||rep=='o');
		}
		catch(StringIndexOutOfBoundsException e){
			return false;
		}
	}

	public static void affiche(Dimension taille2) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
