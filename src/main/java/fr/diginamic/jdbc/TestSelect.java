package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ResourceBundle database = ResourceBundle.getBundle("database");

		Class.forName(database.getString("database.driver"));

		// Etape 2 - Créer une connexion
		String url = database.getString("database.url"); // url JDBC d'accès à la base (machine, port, le nom de la
															// base, le type de base...)
		String utilisateur = database.getString("database.user");
		String motDePasse = database.getString("database.pass");

		List<Fournisseur> fours = new ArrayList<Fournisseur>();

		try (Connection uneConnexion = DriverManager.getConnection(url, utilisateur, motDePasse)) {

			uneConnexion.setAutoCommit(false);

			try (Statement statement = uneConnexion.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from  FOURNISSEUR");) {

				while (resultSet.next()) {
					Integer id = resultSet.getInt("id");
					String nom = resultSet.getString("nom");

					fours.add(new Fournisseur(id, nom));
				}

			} catch (SQLException e) {
				uneConnexion.rollback();
			}

			for (int i = 0; i < fours.size(); i++) {
				System.out.println(fours.get(i));
			}
		}

	}
}
