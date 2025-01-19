package main;

import java.sql.*;

public class GestioneDB
{
	/**
	 * Crea le tabelle nel database, se non esistono già.
	 * 
	 * @param conn Apertura della connessione al DB
	 */

	public static void createTabelle(Connection conn)
	{
		try (Statement stmt = conn.createStatement())
		{

			// Creazione tabella DIPENDENTI
			String createTabellaDipendenti = "CREATE TABLE IF NOT EXISTS dipendenti ("
					+ "id INT NOT NULL AUTO_INCREMENT, " + "nome VARCHAR(30) NOT NULL, "
					+ "cognome VARCHAR(45) NOT NULL, " + "stipendio DECIMAL(8,2) NOT NULL, "
					+ "id_team INT DEFAULT NULL, " + "PRIMARY KEY (id), KEY id_team_idx (id_team), "
					+ "CONSTRAINT id_teamfk FOREIGN KEY (id_team) " + "REFERENCES team (id)"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

			// Creazione tabella TEAM
			String createTabellaTeam = "CREATE TABLE IF NOT EXISTS team (id INT NOT NULL AUTO_INCREMENT, "
					+ "nome VARCHAR(30) DEFAULT NULL, " + "PRIMARY KEY (id)"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

			// Creazione tabella DEVELOPERS
			String createTabellaDevelopers = "CREATE TABLE IF NOT EXISTS developers (" + "id_dipendente INT NOT NULL, "
					+ "PRIMARY KEY (id_dipendente), "
					+ "CONSTRAINT id_dipendenteFK FOREIGN KEY (id_dipendente) REFERENCES dipendenti (id) "
					+ "ON DELETE CASCADE " + "ON UPDATE CASCADE"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

			// Creazione tabella LINGUAGGI
			String createTabellaLinguaggi = "CREATE TABLE IF NOT EXISTS linguaggi ("
					+ "id INT NOT NULL AUTO_INCREMENT, " + "nome VARCHAR(45) NOT NULL, " + "PRIMARY KEY (id)"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

			// Creazione tabella LINGUAGGI_DEVELOPER
			String createTabellaLinguaggiDeveloper = "CREATE TABLE IF NOT EXISTS linguaggi_developer ("
					+ "id_developer INT NOT NULL, " + "id_linguaggio INT NOT NULL, "
					+ "esperienza ENUM('Beginner','Intermediate','Expert') DEFAULT NULL, "
					+ "PRIMARY KEY (id_developer, id_linguaggio), " + "KEY id_linguaggio_idx (id_linguaggio), "
					+ "CONSTRAINT id_developer FOREIGN KEY (id_developer) REFERENCES developers (id_dipendente), "
					+ "CONSTRAINT id_linguaggio FOREIGN KEY (id_linguaggio) REFERENCES linguaggi (id)"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

			// Creazione tabella MANAGERS
			String createTabellaManagers = "CREATE TABLE IF NOT EXISTS managers (id_dipendente INT NOT NULL, "
					+ "bonus DECIMAL(4,2) NOT NULL, " + "team_gestito INT NOT NULL, " + "PRIMARY KEY (id_dipendente), "
					+ "KEY team_gestito_idx (team_gestito), "
					+ "CONSTRAINT id_dipendente FOREIGN KEY (id_dipendente) REFERENCES dipendenti (id) "
					+ "ON DELETE CASCADE " + "ON UPDATE CASCADE, "
					+ "CONSTRAINT team_gestito FOREIGN KEY (team_gestito) REFERENCES team (id)"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

			// Creazione tabella PROGETTI
			String createTabellaProgetti = "CREATE TABLE IF NOT EXISTS progetti (id INT NOT NULL AUTO_INCREMENT, "
					+ "nome VARCHAR(45) NOT NULL, " + "scadenza DATE NOT NULL, " + "PRIMARY KEY (id)"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

			// Creazione tabella TEAM_PROGETTI
			String createTabellaTeamProgetti = "CREATE TABLE IF NOT EXISTS team_progetti (id_team INT NOT NULL, "
					+ "id_progetto INT NOT NULL, " + "PRIMARY KEY (id_team, id_progetto), "
					+ "KEY id_progetto_idx (id_progetto), "
					+ "CONSTRAINT id_progettofk1 FOREIGN KEY (id_progetto) REFERENCES progetti (id), "
					+ "CONSTRAINT id_team FOREIGN KEY (id_team) REFERENCES team (id)"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

			stmt.execute(createTabellaTeam);
			stmt.execute(createTabellaDipendenti);
			stmt.execute(createTabellaDevelopers);
			stmt.execute(createTabellaLinguaggi);
			stmt.execute(createTabellaLinguaggiDeveloper);
			stmt.execute(createTabellaManagers);
			stmt.execute(createTabellaProgetti);
			stmt.execute(createTabellaTeamProgetti);

			System.out.println("Tabelle create/verificate correttamente.");

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Elimina le tabelle nel database, se non esistono già.
	 * 
	 * @param conn Apertura della connessione al DB
	 */

	public static void dropTabelle(Connection conn)
	{

		try (Statement stmt = conn.createStatement())
		{

			// Cancellazione tabella TEAM_PROGETTI
			String createTabellaTeamProgetti = "DROP TABLE IF EXISTS TEAM_PROGETTI;";

			// Cancellazione tabella PROGETTI
			String createTabellaProgetti = "DROP TABLE IF EXISTS PROGETTI;";

			// Cancellazione tabella MANAGERS
			String createTabellaManagers = "DROP TABLE IF EXISTS MANAGERS;";

			// Cancellazione tabella LINGUAGGI_DEVELOPER
			String createTabellaLinguaggiDeveloper = "DROP TABLE IF EXISTS LINGUAGGI_DEVELOPER;";

			// Cancellazione tabella LINGUAGGI
			String createTabellaLinguaggi = "DROP TABLE IF EXISTS LINGUAGGI;";

			// Cancellazione tabella DEVELOPERS
			String createTabellaDevelopers = "DROP TABLE IF EXISTS DEVELOPERS;";

			// Cancellazione tabella TEAM
			String createTabellaTeam = "DROP TABLE IF EXISTS TEAM;";

			// Cancellazione tabella DIPENDENTI
			String createTabellaDipendenti = "DROP TABLE IF EXISTS DIPENDENTI;";

			stmt.execute(createTabellaTeamProgetti);
			stmt.execute(createTabellaProgetti);
			stmt.execute(createTabellaManagers);
			stmt.execute(createTabellaLinguaggiDeveloper);
			stmt.execute(createTabellaLinguaggi);
			stmt.execute(createTabellaDevelopers);
			stmt.execute(createTabellaDipendenti);
			stmt.execute(createTabellaTeam);

			System.out.println("Tabelle eliminate correttamente.");

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
