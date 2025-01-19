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
	
	public static void inserisciProgetto(Connection conn, Scanner scanner)
	{
		System.out.print("Inserisci nome del progetto: ");
		String nome = scanner.nextLine();

		System.out.print("Inserisci la data di scadenza (yyyy-mm-dd): ");
		String scadenza = scanner.nextLine();

		String QUERY = "INSERT INTO progetti (nome, scadenza) VALUES (?,?);";

		try (PreparedStatement pstmt = conn.prepareStatement(QUERY))
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
	
	/**
	 * Metodo di lettura di tutti i progetti
	 *
	 * @param conn   Apertura della connessione al DB
	 */

	public static void letturaDatiProgetto(Connection conn)
	{
		String QUERY = "SELECT * FROM progetti";

		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);)
		{
			while (rs.next())
			{
				int id_progetto = rs.getInt("id");
				String nome = rs.getString("nome");
				String scadenza = rs.getString("scadenza");

				System.out.printf("id: %d | nome: %s | scadenza: %s\n", id_progetto, nome,scadenza);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
