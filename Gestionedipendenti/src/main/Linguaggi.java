package main;

import java.sql.*;
import java.util.Scanner;

public class Linguaggi
{

	/**
	 * Inserisce un nuovo dipendente nella tabella dipendenti.
	 * 
	 * @param credenziali Apertura della connessione al DB
	 * @return L'ID generato per il nuovo dipendente
	 */

	public static void assegnaLinguaggioDev(Credenziali credenziali, Scanner scanner)
	{
		System.out.print("Inserisci l'ID del dipendente: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Inserisci l'ID del linguaggio: ");
		int idLinguaggio = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Inserisci livello di esperienza: ");
		int esperienza = scanner.nextInt();
		scanner.nextLine();

		String QUERY = "INSERT INTO linguaggi_developer (id_developer, id_linguaggio, esperienza) VALUES (?,?,?);";

		try (Connection conn = credenziali.connessione(); PreparedStatement pstmt = conn.prepareStatement(QUERY))
		{
			pstmt.setInt(1, id);
			pstmt.setInt(2, idLinguaggio);
			pstmt.setInt(3, esperienza);
			
			int affectedRows = pstmt.executeUpdate();

			if (affectedRows == 0)
			{
				throw new SQLException("Inserimento fallito, nessuna riga aggiunta.");
			} else
			{
				System.out.println("Linguaggio assegnato con successo al dipendente.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
