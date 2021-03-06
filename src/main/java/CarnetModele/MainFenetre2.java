/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarnetModele;

import Connexions.AccesFichier;
import IConsole.ES;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author alain
 */
public class MainFenetre2 extends javax.swing.JFrame {

	private TabPersonnes listePersonnes = new TabPersonnes();
	private ArrayList<Contact> listeContacts = new ArrayList<>();
	private JPanel boiteContacts = new JPanel();
	private JPanel boiteInfos = new JPanel();
	private Border cadre;
	private int id = 0;
	private int numeroPrec = 0;
	private JButton plusBtn;
	private	JButton moinsBtn;
	private Saisie saisieDialog ;
	
	/**
	 * Creates new form MainFenetre2
	 */
	public MainFenetre2() {
		initComponents();
		setBounds(20, 50, 760, 600);
		setTitle("Fenetre modèle 02");

		Container contenu = getContentPane();
		GridLayout gl = new GridLayout(2,2);
		contenu.setLayout(gl);
		

		
		JScrollPane jScrollPane1 = new JScrollPane();
		contenu.add(jScrollPane1);
		jScrollPane1.add(boiteContacts);
		jScrollPane1.setViewportView(boiteContacts);
		jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste de contacts"));
		Dimension d1 = new Dimension(800,800);
		boiteContacts.setPreferredSize(d1);
		jScrollPane1.setPreferredSize(d1);
		
		contenu.add(boiteInfos);
		boiteInfos.setBorder(javax.swing.BorderFactory.createTitledBorder("Infos"));
		cadre = BorderFactory.createLineBorder(Color.orange);
		this.listePersonnes = initContacts("Donnees/listeContacts.txt");
		peupleContacts(boiteContacts);
		
		boiteInfos.add(new Infos(listePersonnes.retourner(1))) ;
		listeContacts.get(0).setBorder(cadre);
		//listeContacts.get(numeroPrec).setBorder(null);		
		boiteInfos.validate();
		
		JPanel pan1 = new JPanel();
		Dimension d = new Dimension(100, 100);
		pan1.setPreferredSize(d);
		contenu.add(pan1);
		plusBtn = new JButton();
		plusBtn.setText("+");
		plusBtn.setSize(50, 25);
		Dimension dim = new Dimension(100, 20);
		plusBtn.setPreferredSize(dim);
		moinsBtn = new JButton();
		moinsBtn.setText("-");
		moinsBtn.setPreferredSize(dim);	
		pan1.add(plusBtn);
		pan1.add(moinsBtn);
		
	}
	
	private TabPersonnes initContacts(String fic){
		//int id=0;
		TabPersonnes tp = new TabPersonnes();
		String[] info = new String[8];
		AccesFichier ac = new AccesFichier(fic);
		ArrayList<String> al = null;
		try {
			al = ac.lireArray();
		} catch (IOException ex) {
			Logger.getLogger(MainFenetre2.class.getName()).log(Level.SEVERE, null, ex);
		}
		for (String st : al){
			id++;
			info = ac.extraireDonnees(st);
			Personne p = new Personne(id, info);
			tp.ajouter(p);
		}
		return tp;
	}
	
	private void peupleContacts(JPanel boiteContacts){
		// peuplement de la boiteContacts
		Dimension taille;
		for (int i=1; i<=listePersonnes.taille(); i++){
			Contact c = new Contact(listePersonnes.retourner(i));
			taille = c.getPreferredSize();
			c.setBounds(0, (i-1)*(taille.height+2), taille.width, taille.height);
			boiteContacts.add(c);
			taille.setSize(taille.width, (i+1)*(taille.height+2));
			boiteContacts.setPreferredSize(taille);
			boiteContacts.validate();
			ES.affiche(boiteContacts.getComponentCount()+"\n");
			
			listeContacts.add(c);
			listeContacts.get(i-1).addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseReleased(java.awt.event.MouseEvent evt){
					contactMouseEvent(evt);
				}
			});
		}
	}
	
	private void contactMouseEvent(java.awt.event.MouseEvent evt) {
		Contact contactSelectionne = (Contact) evt.getSource();
		id = contactSelectionne.getPerson().getId();
		boiteInfos.removeAll();
		boiteInfos.add(new Infos(listePersonnes.retourner(id))) ;
		contactSelectionne.setBorder(cadre);
		listeContacts.get(numeroPrec).setBorder(null);
		numeroPrec = id-1;
		boiteInfos.validate();
		ES.affiche("\n");
	}
	
	private void plusBtnActionPerformed(java.awt.event.ActionEvent evt){
		saisieDialog = new Saisie(this, true);
		saisieDialog.setVisible(true);
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFenetre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFenetre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFenetre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFenetre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFenetre2().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
