package fr.linuxydable.orgathlon.Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.linuxydable.orgathlon.modele.Course;

import fr.linuxydable.orgathlon.Database.DatabaseSettings;

public class InputCourse {
	
	private PreparedStatement preparedStatement;
    
	public void inputCourse(Course donnees) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("INSERT into Orgathlon.Course values (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, donnees.getNom());
			preparedStatement.setString(2, donnees.getFormat());
			preparedStatement.setDate(3, null);		//TODO date
			preparedStatement.setDate(4, null);			//TODO date
			preparedStatement.setString(5, donnees.getDescriptionCourse());
			preparedStatement.setBoolean(6, donnees.isAgrement());
			preparedStatement.setFloat(7, donnees.getBudget());
			preparedStatement.setInt(8, donnees.getNbParticipants());
			preparedStatement.setInt(9, donnees.getDistance_nat());
			preparedStatement.setInt(10, donnees.getDistance_cyc());
			preparedStatement.setInt(11, donnees.getDistance_cou());
			preparedStatement.setString(12, donnees.getNom_ville_nat());
			preparedStatement.setString(13, donnees.getNom_ville_cyc());
			preparedStatement.setString(14, donnees.getNom_ville_cou());
			preparedStatement.setString(15, donnees.getNom_ville_arr());
			preparedStatement.setString(16, donnees.getCP_ville_nat());
			preparedStatement.setString(17, donnees.getCP_ville_cyc());
			preparedStatement.setString(18, donnees.getCP_ville_cou());
			preparedStatement.setString(19, donnees.getCP_ville_arr());
			preparedStatement.setString(20, donnees.getType_epreuve());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}