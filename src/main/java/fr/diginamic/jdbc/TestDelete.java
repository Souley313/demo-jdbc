package fr.diginamic.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class TestDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ResourceBundle database = ResourceBundle.getBundle("database");

		Class.forName(database.getString("database.driver"));

		// Etape 2 - Créer une connexion
		String url = database.getString("database.url"); // url JDBC d'accès à la base (machine, port, le nom de la
															// base, le type de base...)
		String utilisateur = database.getString("database.user");
		String motDePasse = database.getString("database.pass");

		try (Connection uneConnexion = DriverManager.getConnection(url, utilisateur, motDePasse)) {

			uneConnexion.setAutoCommit(false);

			try (Statement statement = uneConnexion.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from  FOURNISSEUR");) {

				int nbLignesImpactees = statement.executeUpdate("delete from FOURNISSEUR where id = 4");

				uneConnexion.commit();
			} catch (SQLException e) {
				uneConnexion.rollback();
			}
		}

	}


	}


