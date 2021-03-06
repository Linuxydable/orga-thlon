package fr.linuxydable.orgathlon.Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.linuxydable.orgathlon.Database.DatabaseSettings;
import fr.linuxydable.orgathlon.modele.contacts.Contact;
import fr.linuxydable.orgathlon.modele.contacts.ContactExterne;

public class RequestContactExt {

	public Contact requestContactExt(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Contact_Ext WHERE id_Contact = "+ id +";");
			
			if(result.next()) {
				Contact contact = new ContactExterne(result.getString("nom_contact"), result.getString("nom_societe"));
				
				contact.setId_personne(result.getInt("id_Contact"));
				contact.setCivilite(result.getString("civilite"));
				contact.setCommentaire(result.getString("commentaire_contact"));
				contact.setPrenom_c(result.getString("prenom_contact"));
				contact.setAdresse(result.getString("adresse1_contact"));
				contact.setCp_c(result.getString("code_Postal_contact"));
				contact.setVille_c(result.getString("ville_contact"));
				contact.setTelephone_c(result.getString("telephone_contact"));
				contact.setMail_c(result.getString("mail_contact"));
						
				return contact;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
}
