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

	public void assegnaLinguaggioDev(Credenziali credenziali, Scanner scanner)
	{
		System.out.println("Inserisci l'ID del team:");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Nuovo ruolo del dipendente: \n1. Dipendente \n2. Sviluppatore \n3. Manager  ");
		int nuovoRuoloInt = scanner.nextInt();
		scanner.nextLine();
		String nuovoRuolo = "";

		String query = "INSERT INTO linguaggi_developer (id_developer, id_linguaggio, esperienza) VALUES (?,?,?);";

		try (Connection conn = credenziali.connessione(); PreparedStatement pstmt = conn.prepareStatement(query))
		{
			pstmt.setString(1, nuovoRuolo);
			pstmt.setInt(2, id);
			int affectedRows = pstmt.executeUpdate();

			if (affectedRows == 0)
			{
				throw new SQLException("Modifica dipendente fallita, nessuna riga aggiunta.");
			} else
			{
				System.out.println("Dipendente modificato con successo");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}