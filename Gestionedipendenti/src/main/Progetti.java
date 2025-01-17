package main;

import java.sql.*;
import java.util.Scanner;

public class Progetti
{
	
	/**
	 * Metodo per inserire un nuovo progetto
	 *
	 * @param credenziali   Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */
	
	public static void inserisciProgetto(Credenziali credenziali, Scanner scanner)
	{
		System.out.print("Inserisci nome del progetto: ");
		String nome = scanner.nextLine();

		System.out.print("Inserisci la data di scadenza (yyyy-mm-dd): ");
		String scadenza = scanner.nextLine();

		String QUERY = "INSERT INTO progetti (nome, scadenza) VALUES (?,?);";

		try (Connection conn = credenziali.connessione(); PreparedStatement pstmt = conn.prepareStatement(QUERY))
		{
			pstmt.setString(1, nome);
			pstmt.setString(2, scadenza);
			
			int affectedRows = pstmt.executeUpdate();

			if (affectedRows == 0)
			{
				throw new SQLException("Inserimento fallito, nessuna riga aggiunta.");
			} else
			{
				System.out.println("Progetto aggiunto con successo.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
