package fr.linuxydable.orgathlon.Database.UpdateDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.linuxydable.orgathlon.modele.Course ;

import fr.linuxydable.orgathlon.Database.DatabaseSettings;

public class UpdateDatabaseCourse {

	private static PreparedStatement preparedStatement = null;

	public void updateDatabase(Course donnees) {
			
		try {
			Connection database = DatabaseSettings.connect();
	
			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Course SET nom_course=?, format_course=?, date_course=?, description_course=?, lieu=?, nb_participants=?, parcours=?, budget=?, agrementFTTRI=?, nom_ville_nat=?, nom_ville_cyc=?, nom_ville_cou=?, nom_ville_arr=?, CP_ville_nat=?, CP_ville_cyc=?, CP_ville_cou=?, CP_ville_arr=?, type_epreuve=? WHERE id_Course =?");
			preparedStatement.setString(1, donnees.getNom());
			preparedStatement.setString(2, donnees.getFormat());
			preparedStatement.setDate(3, null);									//TODO date
			preparedStatement.setString(4, donnees.getDescriptionCourse());
			preparedStatement.setInt(6, donnees.getNbParticipants());
			preparedStatement.setString(7, donnees.getParcours());
			preparedStatement.setFloat(8, donnees.getBudget());
			preparedStatement.setBoolean(9, donnees.isAgrement());
			preparedStatement.setString(10, donnees.getNom_ville_nat());
			preparedStatement.setString(11, donnees.getNom_ville_cyc());
			preparedStatement.setString(12, donnees.getNom_ville_cou());
			preparedStatement.setString(13, donnees.getNom_ville_arr());
			preparedStatement.setString(14, donnees.getCP_ville_nat());
			preparedStatement.setString(15, donnees.getCP_ville_cyc());
			preparedStatement.setString(16, donnees.getCP_ville_cou());
			preparedStatement.setString(17, donnees.getCP_ville_arr());
			preparedStatement.setString(18, donnees.getType_epreuve());
			preparedStatement.setInt(19, donnees.getId_course());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		
	}
}