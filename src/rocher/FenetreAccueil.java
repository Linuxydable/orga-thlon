package rocher;

import java.awt.BorderLayout;

import javax.swing.*;

public class FenetreAccueil extends JFrame{
	
	public FenetreAccueil () {
		this.setTitle("Orgathlon");
		this.setVisible(true);
		this.setSize(800, 800);
		//this.setLayout(new BorderLayout());
		VueOnglets v= new VueOnglets();
		this.setLayout(new BorderLayout());
		this.add(v,BorderLayout.WEST);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}