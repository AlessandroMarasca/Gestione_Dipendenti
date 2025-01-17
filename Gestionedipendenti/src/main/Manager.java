package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manager extends Employee {
	double bonus;
	String teamGestito;
	
	
	public Manager(int id, String nome, String cognome, double stipendio, int idTeam, double bonus, String teamGestito) {
		super(id, nome, cognome, stipendio, idTeam);
		this.bonus = bonus;
		this.teamGestito = teamGestito;
	}
	public static void assegnaDipendenteManager(Credenziali credenziali, Scanner scanner)
	{
		System.out.print("Inserisci l'ID del dipendente manager: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		String QUERY = "INSERT INTO manager (id_dipendente) VALUES (?);";

		try (Connection conn = credenziali.connessione(); PreparedStatement pstmt = conn.prepareStatement(QUERY))
		{
			pstmt.setInt(1, id);

			int affectedRows = pstmt.executeUpdate();

			if (affectedRows == 0)
			{
				throw new SQLException("Inserimento fallito, nessuna riga aggiunta.");
			} else
			{
				System.out.println("Manager aggiunto con successo.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
	public static void visualizzaManager(Credenziali credenziali, Scanner scanner)
	{

		String QUERY = "SELECT dipendenti.id_dipendente, dipendenti.nome, dipendenti.cognome,"
				+ "dipendenti.stipendio," + "dipendenti.id_team" + " FROM manager "
				+ "INNER JOIN dipendenti ON manager.id_dipendente = dipendenti.id_dipendente;";

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