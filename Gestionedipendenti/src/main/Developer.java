package main;

import java.sql.*;
import java.util.Scanner;

public class Developer extends Employee
{
	int IdLinguaggi;
	int progettoAssegnato;

	// INIZIALIZZIAMO IL COSTRUTTORE

	public Developer(int id, String nome, String cognome, double stipendio, int idTeam, int IdLinguaggi,
			int progettoAssegnato)
	{
		super(id, nome, cognome, stipendio, idTeam);
	}
	
	/**
	 * Metodo che assegna il ruolo di developer ad un dipendente
	 *
	 * @param credenziali   Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */

	public static void assegnaDipendenteDev(Credenziali credenziali, Scanner scanner)
	{
		System.out.print("Inserisci l'ID del dipendente developer: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		String QUERY = "INSERT INTO developers (id_dipendente) VALUES (?);";

		try (Connection conn = credenziali.connessione(); PreparedStatement pstmt = conn.prepareStatement(QUERY))
		{
			pstmt.setInt(1, id);

			int affectedRows = pstmt.executeUpdate();

			if (affectedRows == 0)
			{
				throw new SQLException("Inserimento fallito, nessuna riga aggiunta.");
			} else
			{
				System.out.println("Developer aggiunto con successo.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * Metodo che permette di visualizzare l'elenco dei devs
	 *
	 * @param credenziali   Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */

	public static void visualizzaDevelopers(Credenziali credenziali, Scanner scanner)
	{

		String QUERY = "SELECT dipendenti.id_dipendente, dipendenti.nome, dipendenti.cognome,"
				+ "dipendenti.stipendio," + "dipendenti.id_team" + " FROM developers "
				+ "INNER JOIN dipendenti ON developers.id_dipendente = dipendenti.id_dipendente;";

		try (Connection conn = credenziali.connessione();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);)
		{
			while (rs.next())
			{
				int id = rs.getInt("id_dipendente");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				double stipendio = rs.getInt("stipendio");
				int idTeam = rs.getInt("id_team");

				System.out.printf("id: %d | nome: %s | cognome: %s | stipendio: %.2f | team: %d\n", id, nome, cognome, stipendio, idTeam);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
