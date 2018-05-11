package fr.linuxydable.orgathlon.Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.linuxydable.orgathlon.Database.DatabaseSettings;
import fr.linuxydable.orgathlon.modele.contacts.Benevole;
import fr.linuxydable.orgathlon.modele.contacts.Contact;

public class RequestBenevole {

	public Contact requestBenevole(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Benevole WHERE id_Personne = "+ id +";");
			
			if(result.next()) {
				Contact contact = new Benevole(result.getString("nom_benevole"));
				
				contact.setId_personne(result.getInt("id_Personne"));
				contact.setCivilite(result.getString("civilite_benevole"));
				contact.setCommentaire(result.getString("commentaire_benevole"));
				contact.setPrenom_c(result.getString("prenom_benevole"));
				contact.setAdresse(result.getString("adresse_benevole"));
				contact.setCp_c(result.getString("codePostal_benevole"));
				contact.setVille_c(result.getString("ville_benevole"));
				contact.setTelephone_c(result.getString("telephone_benevole"));
				contact.setMail_c(result.getString("mail_personnel"));
						
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
