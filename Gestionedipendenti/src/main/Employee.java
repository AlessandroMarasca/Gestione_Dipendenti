package main;

import java.sql.*;
import java.util.Scanner;

//CLASSE MADRE
public class Employee
{

	/**
	 * Mostra la lista di tutti i records della tabella dipendenti.
	 *
	 * @param credenziali Apertura della connessione al DB
	 */

	public static void letturaDatiDipendenti(Connection conn)
	{
		String QUERY = "SELECT * FROM dipendenti";

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(QUERY);)
		{
			while (rs.next())
			{
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				double stipendio = rs.getInt("stipendio");

				System.out.printf("id: %d | nome: %s | cognome: %s | stipendio: %.2f\n", id, nome, cognome, stipendio);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Inserisce un nuovo dipendente nella tabella dipendenti.
	 *
	 * @param nome          Nome del dipendente
	 * @param cognome       Cognome del dipendente
	 * @param stipendioBase Stipendio del dipendente
	 * @param idTeam        Team a cui appartiene
	 * @param credenziali   Apertura della connessione al DB
	 * @return L'ID generato per il nuovo dipendente
	 */

	public static int inserisciNuovoDipendente(Connection conn, Scanner scanner)
	{

		System.out.print("Inserisci il nome del dipendente: ");
		String nome = scanner.nextLine();

		System.out.print("Inserisci il cognome del dipendente: ");
		String cognome = scanner.nextLine();

		System.out.print("Inserisci lo stipendio base: ");
		double stipendio = scanner.nextDouble();

		System.out.print("Inserisci l'ID del team: ");
		int idTeam = scanner.nextInt();
		String QUERY = "INSERT INTO dipendenti (nome, cognome, stipendio, id_team) VALUES (?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS))
		{

			pstmt.setString(1, nome);
			pstmt.setString(2, cognome);
			pstmt.setDouble(3, stipendio);
			pstmt.setInt(4, idTeam);

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows == 0)
			{
				throw new SQLException("Creazione dipendente fallita, nessuna riga aggiunta.");
			}

			// Recupero la chiave generata (ID auto-increment)
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys())
			{
				if (generatedKeys.next())
				{
					return generatedKeys.getInt(1);
				} else
				{
					throw new SQLException("Creazione dipendente fallita, ID non recuperato.");
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1; // In caso di errore
	}

	/**
	 * Inserisce un nuovo dipendente in un team.
	 *
	 * @param conn    Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */

	public static void assegnaDipendenteTeam(Connection conn, Scanner scanner)

	{
		System.out.println("Inserisci id dipendente a cui vuoi assegnare un team:");
		int id = scanner.nextInt();
		System.out.print("Inserisci id del team: ");
		int id_team = scanner.nextInt();
		String sql = "UPDATE dipendenti SET id_team=? WHERE id=?";
		try (

				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
		{

			pstmt.setInt(1, id_team);
			pstmt.setInt(2, id);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0)
			{
				System.out.println("Dipendente con ID " + id + " assegnato correttamente al team: " + id_team);
			} else
			{
				System.out.println("Nessun dipendente assegnato. Verificare l'ID.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Elimina un dipendente
	 *
	 * @param conn    Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */

	public static void eliminaDipendente(Connection conn, Scanner scanner)
	{
		System.out.println("Ecco la lista completa dei dipendenti.");
		letturaDatiDipendenti(conn);
		System.out.println("Chi desidera eliminare? Inserisci ID per continuare.");
		int id = scanner.nextInt();
		scanner.nextLine();
		try (PreparedStatement psDel = conn.prepareStatement("DELETE FROM dipendenti WHERE id = ?");)
		{
			// ResultSet rs = psDel.executeQuery();
			psDel.setInt(1, id);
			int affectedrows = psDel.executeUpdate();
			if (affectedrows == 0)
			{
				throw new SQLException("Modifica dipendente fallita, nessuna riga eliminata.");
			} else
			{
				System.out.println("Dipendente eliminato con successo");
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Metodo che modifica lo stipendio di un dipendente
	 *
	 * @param conn    Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */

	public static void modificaStipendi(Connection conn, Scanner scanner)
	{

		System.out.print("A quale dipendente vuoi modificare stipendio? Inserire id:");
		int id = scanner.nextInt();
		System.out.print("Inserisci cifra nuovo stipendio");
		int stipendio = scanner.nextInt();
		String QUERY = "UPDATE dipendenti SET stipendio=? WHERE id=?";
		try (PreparedStatement pstmt = conn.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS))
		{

			pstmt.setInt(1, stipendio);
			pstmt.setInt(2, id);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0)
			{
				System.out.println("Stipendio modificato correttamente per dipendente con ID " + id);
			} else
			{
				System.out.println("Nessun dipendente trovato. Verificare l'ID.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
}
