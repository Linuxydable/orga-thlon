package fr.linuxydable.orgathlon.controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat ;
import javax.swing.JButton;
import java.util.Date ;
import fr.linuxydable.orgathlon.vue.FenetreNouvelleCourse;
import fr.linuxydable.orgathlon.Database.InputDataBase.InputCourse;
import fr.linuxydable.orgathlon.modele.Course ;
import fr.linuxydable.orgathlon.Database.InputDataBase.InputCourse ;
import java.util.HashMap ;

public class ControleurNouvelleCourse implements ActionListener {

	private enum Etats {CONSULTATION, EDITION};
	private Etats etatCourant;
	private FenetreNouvelleCourse vue;
	private Course modele;
	
	
	public ControleurNouvelleCourse(FenetreNouvelleCourse vue) throws Exception {	
		this.vue = vue ;
		this.modele = new Course("nouveau") ;
		this.etatCourant = Etats.EDITION;
	}
	
	public void actionPerformed (ActionEvent e) {
		JButton b = (JButton) e.getSource() ;
			switch (this.etatCourant) {
			case EDITION :
				if (b.getText().equals("valider")) {
					this.etatCourant = Etats.CONSULTATION ;
					this.vue.titreFenetreSaisi(true);
					this.vue.setActifComposants(false);
					this.vue.modifierTexteBoutonsPourEdition(false);
					/*
					try {
						InputCourse.input(fr.linuxydable.orgathlon.modele);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
					*/
				}else if (b.getText().equals("annuler")) {
					System.exit(0);
				} //else if bouton effacer

			case CONSULTATION :

				if (b.getText().equals("retour")) {
					this.etatCourant = Etats.EDITION ;
					this.vue.modifierTexteBoutonsPourEdition(true);
					this.vue.setActifComposants(true);
					this.vue.titreFenetreSaisi(false);

				}
			
			
				
			}
			
			}
	

	public Course convertirMap(HashMap <String, Object> donneesCourses) throws Exception {

        Course nouvelleCourse = new Course("nouveau") ;

        nouvelleCourse.setNom( String.valueOf( donneesCourses.get("nom_courseVue"))) ;
        Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(donneesCourses.get("date_debut_courseVue")));
        nouvelleCourse.setDate_debut_course(d1) ;
        Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(donneesCourses.get("date_fin_courseVue")));
        nouvelleCourse.setDate_fin_course(d2) ;
        nouvelleCourse.setNbParticipants( Integer.parseInt(String.valueOf( donneesCourses.get("nbParticipantsVue")))) ; 
        nouvelleCourse.setAgrement(Boolean.valueOf(String.valueOf( donneesCourses.get("agrementVue")))) ; 
        nouvelleCourse.setNom( String.valueOf( donneesCourses.get("type_epreuveVue"))) ; 
        nouvelleCourse.setNom( String.valueOf( donneesCourses.get("formatVue"))) ; 
        nouvelleCourse.setDistance_nat( Integer.parseInt(String.valueOf( donneesCourses.get("distance_natVue")))) ; 
        nouvelleCourse.setDistance_cyc( Integer.parseInt(String.valueOf( donneesCourses.get("distance_cycVue")))) ;
        nouvelleCourse.setDistance_cou( Integer.parseInt(String.valueOf( donneesCourses.get("distance_couVue")))) ;
        nouvelleCourse.setNom_ville_nat( String.valueOf( donneesCourses.get("nom_ville_natVue"))) ; 
        nouvelleCourse.setNom_ville_cyc( String.valueOf( donneesCourses.get("nom_ville_cycVue"))) ; 
        nouvelleCourse.setNom_ville_cou( String.valueOf( donneesCourses.get("nom_ville_couVue"))) ; 
        nouvelleCourse.setNom_ville_arr( String.valueOf( donneesCourses.get("nom_ville_arrVue"))) ; 
        nouvelleCourse.setCP_ville_nat( String.valueOf( donneesCourses.get("CP_ville_natVue"))) ; 
        nouvelleCourse.setCP_ville_cyc( String.valueOf( donneesCourses.get("CP_ville_cycVue"))) ; 
        nouvelleCourse.setCP_ville_cou( String.valueOf( donneesCourses.get("CP_ville_couVue"))) ;
        nouvelleCourse.setCP_ville_arr( String.valueOf( donneesCourses.get("CP_ville_arrVue"))) ; 
        nouvelleCourse.setDescriptionCourse( String.valueOf( donneesCourses.get("description_courseVue"))) ; 
        
        return nouvelleCourse ;
	}
	
}
	
	/*
	 * 
	 * 
	 * 					antis�che
	 * 
	 * 
	 * 
	 * 	public void actionPerformed(ActionEvent arg0) {
	
		JButton boutonSource = (JButton) arg0.getSource();
		
		if (boutonSource.getText().equals("VALIDER")) this.etatCourant=etats.CHOIX_POSITION; 
			
		
			
		switch(this.etatCourant) {
			
			case DEBUT_COMBINAISON :
				
				//sauvegarde la couleur choisie
				if (!fr.linuxydable.orgathlon.vue.appartientPalette(boutonSource)) break;
				couleurChoisie = boutonSource.getBackground();
				this.etatCourant=etats.CHOIX_COULEUR;
				break;
			
			case CHOIX_COULEUR :
				
				// met la couleur sauvegard�e dans le bouton de la combinaison choisie
				if(this.fr.linuxydable.orgathlon.vue.appartientCombinaison(boutonSource, ligne)) {
				boutonSource.setBackground(couleurChoisie);
				this.etatCourant=etats.DEBUT_COMBINAISON;
				}
				break;
							
				
			case CHOIX_POSITION :
											
				if (!fr.linuxydable.orgathlon.vue.combinaisonComplete(ligne)) {
					this.etatCourant=etats.DEBUT_COMBINAISON;
					break;
				}
				// afficher le nombre de couleurs bien plac�es de la combinaison courante
				int nbBP = this.fr.linuxydable.orgathlon.modele.nbChiffresBienPlaces(fr.linuxydable.orgathlon.vue.combinaisonEnEntiers(ligne));
				this.fr.linuxydable.orgathlon.vue.afficherBP(ligne, nbBP);
				// afficher le nombre de couleurs mal plac�es de la combinaison courante
				int nbMP = this.fr.linuxydable.orgathlon.modele.nbChiffresMalPlaces(fr.linuxydable.orgathlon.vue.combinaisonEnEntiers(ligne));
				this.fr.linuxydable.orgathlon.vue.afficherMP(ligne, nbMP);
				// d�sactiver les boutons de la combinaison courante
				this.fr.linuxydable.orgathlon.vue.desactiverCombinaison(ligne);
				
				if ( nbBP != this.fr.linuxydable.orgathlon.vue.getTaille()) {
				// Si la combinaison n'est pas trouv�e, 2 possibilit�s : il reste des essais ou pas
					
					if(ligne < nbEssai-1) {
						// Il reste encore des essais
						this.etatCourant = etats.DEBUT_COMBINAISON;
						this.ligne +=1;
						this.fr.linuxydable.orgathlon.vue.activerCombinaison(ligne);
						break;
						
					}
				}else {
				// La combinaison est trouv�e  
						// il ne reste plus d'essais
				this.etatCourant = etats.FIN;
				}
				
			case FIN :	
				
				this.fr.linuxydable.orgathlon.vue.afficherCombinaisonOrdinateur(this.fr.linuxydable.orgathlon.modele.getCombinaison());
				
			break;	
			}
		}
	 */
	
	

