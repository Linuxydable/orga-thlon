package fr.linuxydable.orgathlon.modele.contacts;
import fr.linuxydable.orgathlon.modele.Tache;

public class Responsable {

	private Contact contact;
	private Tache tache;
	
	public Responsable(Contact contact, Tache tache) {
		this.contact = contact;
		this.tache = tache;
	}
}
