package fr.linuxydable.orgathlon.modele;

import java.util.Date;
import java.util.LinkedList;
import fr.linuxydable.orgathlon.modele.contacts.Benevole;

public class Tache {

	private int id_Tache;
	private String libelle;
	private String commentaire;
	private Date dateDebut;
	private Date dateEcheance;
	private float etatAvancement;
	private Date dateRappel;
	private String frequenceRappel;
	private int priorite;
	private boolean predefinie;
	private int tempsRestant;
	private Date dateCreationTache;
	private String etatAvancementGlobal;
	//attributs manquants: responsable de la t�che

	private LinkedList<Materiel> materiel;
	private LinkedList<Benevole> benevole;
	
	public Tache(String libelle, Date dateDebut) {
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateCreationTache = new Date();
		
		this.materiel = new LinkedList<Materiel>();
		this.benevole = new LinkedList<Benevole>();
		
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public double getEtatAvancement() {
		return etatAvancement;
	}

	public void setEtatAvancement(float etatAvancement) {
		this.etatAvancement = etatAvancement;
	}

	public Date getDateRappel() {
		return dateRappel;
	}

	public void setDateRappel(Date dateRappel) {
		this.dateRappel = dateRappel;
	}

	public String getFrequenceRappel() {
		return frequenceRappel;
	}

	public void setFrequenceRappel(String frequenceRappel) {
		this.frequenceRappel = frequenceRappel;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public int getTempsRestant() {
		return tempsRestant;
	}

	public void setTempsRestant(int tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	public Date getDateCreationTache() {
		return dateCreationTache;
	}

	public void setDateCreationTache(Date dateCreationTache) {
		this.dateCreationTache = dateCreationTache;
	}

	public String getEtatAvancementGlobal() {
		return etatAvancementGlobal;
	}

	public void setEtatAvancementGlobal(String etatAvancementGlobal) {
		this.etatAvancementGlobal = etatAvancementGlobal;
	}
	
	public void ajouterMateriel(Materiel item) {
		this.materiel.add(item);
	}
	
	public void ajouterBenevole(Benevole personnel) {
		this.benevole.add(personnel);
	}

	public boolean isPredefinie() {
		return predefinie;
	}

	public void setPredefinie(boolean predefinie) {
		this.predefinie = predefinie;
	}
	
	public int getId_Tache() {
		return id_Tache;
	}

	public void setId_Tache(int id_Tache) {
		this.id_Tache = id_Tache;
	}

	
}
