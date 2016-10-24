package CarnetModele;

import Connexions.AccesFichier;
import IConsole.ES;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	private TabPersonnes listePersonnes = new TabPersonnes();
	private ArrayList<Contact> listeContacts = new ArrayList<>();
	private String nomDonnees = "Donnees/listeContacts.txt";
	
	private JPanel contentPane;	
	private JPanel boiteContacts = new JPanel();
	private JPanel boiteInfos = new JPanel();
	private Border cadre;
	private int id = 0;
	private int numeroPrec = 0;
	private JButton plusBtn;
	private	JButton moinsBtn;
	private Saisie saisieDialog ;
	private JFrame mainFrame = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFenetre frame = new MainFenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFenetre() {
		
		saisieDialog = new Saisie(mainFrame, true);
		saisieDialog.setLocationRelativeTo(mainFrame);
		
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{250, 250};
		gbl_contentPane.rowHeights = new int[]{550, 0};
		gbl_contentPane.columnWeights = new double[]{5.0, 5.0};
		gbl_contentPane.rowWeights = new double[]{9.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBorder(new TitledBorder(null, "Liste de contacts", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jScrollPane1 = new GridBagConstraints();
		gbc_jScrollPane1.insets = new Insets(0, 0, 5, 5);
		gbc_jScrollPane1.fill = GridBagConstraints.BOTH;
		gbc_jScrollPane1.gridx = 0;
		gbc_jScrollPane1.gridy = 0;
		contentPane.add(jScrollPane1, gbc_jScrollPane1);
		
		//JPanel boiteContacts = new JPanel();
		jScrollPane1.setViewportView(boiteContacts);
		
		//JPanel boiteInfos = new JPanel();
		boiteInfos.setBorder(new TitledBorder(null, "Infos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_boiteInfos = new GridBagConstraints();
		gbc_boiteInfos.fill = GridBagConstraints.BOTH;
		gbc_boiteInfos.insets = new Insets(0, 0, 5, 5);
		gbc_boiteInfos.gridx = 1;
		gbc_boiteInfos.gridy = 0;
		contentPane.add(boiteInfos, gbc_boiteInfos);
		
		JPanel panBouttons = new JPanel();
		GridBagConstraints gbc_panBouttons = new GridBagConstraints();
		gbc_panBouttons.insets = new Insets(0, 0, 0, 5);
		gbc_panBouttons.fill = GridBagConstraints.BOTH;
		gbc_panBouttons.gridx = 0;
		gbc_panBouttons.gridy = 1;
		contentPane.add(panBouttons, gbc_panBouttons);
		
		plusBtn = new JButton("+");
		plusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saisieDialog.setVisible(true);
				if (saisieDialog.getDonnees()) {
					boiteContacts.removeAll();
					listePersonnes = ControleAdresse.lirePersonnes(nomDonnees);
					peupleContacts(boiteContacts);
				}
			}
		});
		panBouttons.add(plusBtn);
		
		moinsBtn = new JButton("-");
		moinsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saisieDialog.supprimer(id);	
				boiteContacts.removeAll();
				boiteContacts.repaint();
				id=1;
				listePersonnes = ControleAdresse.lirePersonnes(nomDonnees);
				peupleContacts(boiteContacts);				
			}
		});
		panBouttons.add(moinsBtn);
		
		cadre = BorderFactory.createLineBorder(Color.orange);
		listePersonnes = ControleAdresse.lirePersonnes(nomDonnees);
		peupleContacts(boiteContacts);
		
		boiteInfos.add(new Infos(listePersonnes.retourner(1))) ;
		listeContacts.get(0).setBorder(cadre);
		//listeContacts.get(numeroPrec).setBorder(null);		
		boiteInfos.validate();
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
	}
	
}
