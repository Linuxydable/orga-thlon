package fr.linuxydable.orgathlon.vue;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreNouvelleSousTache extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetreNouvelleSousTache() {
		this.setTitle("cr�ation d'une nouvelle fiche SOUS-TACHE");
		this.setLayout(new GridLayout(1,1));
		this.add(new VueNouvelleSousTache());
		
		this.pack();
		this.setSize(400, 300);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
