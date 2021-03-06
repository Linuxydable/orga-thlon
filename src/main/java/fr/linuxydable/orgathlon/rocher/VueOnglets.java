package fr.linuxydable.orgathlon.rocher;
import fr.linuxydable.orgathlon.vue.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


	
	public class VueOnglets extends JPanel{
		
		/*
		public VueOnglets() {
			ImageIcon image= new ImageIcon("rocher/contacts.png");
			ImageIcon image2= new ImageIcon("rocher/f0_accueilpopupout.png");
			VueUnOnglet p = new VueUnOnglet();
			VueUnOnglet p2 = new VueUnOnglet();
			p2.setTest();
			
			this.addTab("tab1", image2, p);
			this.addTab("tab2", image, p2);
		}
		*/
		public VueOnglets() {
			JTabbedPane onglets = new JTabbedPane();
			String path = new File("").getAbsolutePath();
			ImageIcon image= new ImageIcon(path +"rocher/contacts.png");
			ImageIcon image2= new ImageIcon(path +"rocher/f0_accueilpopupout.png");
			//JTabbedPane onglets2 = new JTabbedPane();
			VueUnOnglet p = new VueUnOnglet();
			VueUnOnglet p2 = new VueUnOnglet();
		
			p2.setTest();
			this.setLayout(new GridLayout(1,2));
			
			onglets.setTabPlacement(JTabbedPane.LEFT);
			//onglets.setOpaque(true);
			onglets.addTab("tab1", resize(image2), new VueNouveauContactExterne());
			//onglets.setMnemonicAt(0, KeyEvent.VK_2);
			
			onglets.addTab("tab2", resize(image), p2);
			//onglets.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			
			//onglets.setLayout(new GridLayout(2, 1));
			//onglets2.addTab("tab2", new ImageIcon("fr.linuxydable.orgathlon.rocher/contacts.png"), p);
			
			this.add(onglets);
			//this.add(onglets2);
			
		}
		
		public ImageIcon resize (ImageIcon i) {
			;
			return new ImageIcon(i.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		}

}
