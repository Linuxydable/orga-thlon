package fr.linuxydable.orgathlon.Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.linuxydable.orgathlon.Database.DatabaseSettings;
import fr.linuxydable.orgathlon.modele.Materiel;

public class RequestMateriel {
	
	public Materiel requestMateriel(int id) {

		try {
			Connection database = DatabaseSettings.connect();
			Statement state;
			
			state = database.createStatement();
			
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Materiel WHERE id_Materiel = "+ id +";");
			
			if(result.next()) {
				Materiel materiel = new Materiel(result.getString("libelle_mat"));
				
				materiel.setId_materiel(result.getInt("id_Materiel"));
				materiel.setStock(result.getInt("stock"));
				materiel.setBudget(result.getDouble("budget_mat"));
				materiel.setDescription(result.getString("description_mat"));
				
				return materiel;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}

}
