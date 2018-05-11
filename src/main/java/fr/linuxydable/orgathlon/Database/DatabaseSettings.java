package fr.linuxydable.orgathlon.Database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseSettings {

	private static final String SERVEUR = "...";
	private static final String USER = "...";
	private static final String MDP = "...";
	private static Connection connect;

	public static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://"+ SERVEUR + "?user="+ USER +"&password="+ MDP);
			return connect;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close() {
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
