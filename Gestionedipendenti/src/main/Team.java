package main;

import java.sql.*;
import java.util.Scanner;

public class Team {
	
	/**
	 * Metodo per inserire un nuovo team
	 *
	 * @param conn   Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */
	
	public static void inserisciNuovoTeam(Connection conn, Scanner scanner)
	{
		System.out.print("Inserisci nome del team: ");
		String nome = scanner.nextLine();

		String QUERY = "INSERT INTO team (nome) VALUES (?);";

		try (PreparedStatement pstmt = conn.prepareStatement(QUERY))
		{
			pstmt.setString(1, nome);
			
			int affectedRows = pstmt.executeUpdate();

			if (affectedRows == 0)
			{
				throw new SQLException("Inserimento fallito, nessuna riga aggiunta.");
			} else
			{
				System.out.println("Team aggiunto con successo.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo che visualizza tutti i team
	 *
	 * @param conn   Apertura della connessione al DB
	 */
	
	public static void letturaDatiTeam(Connection conn)
	{
		String QUERY = "SELECT * FROM Team";

		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);)
		{
			while (rs.next())
			{
				int id_team = rs.getInt("id");
				String nome = rs.getString("nome");
				

				System.out.printf("id: %d | nome: %s", id_team, nome);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo che assegna un progetto ad un team
	 *
	 * @param conn   Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */
	
	public static void assegnaTeamProgetto(Connection conn, Scanner scanner) {
		
		System.out.println("Ecco la lista completa dei team.");
		letturaDatiTeam(conn);
		System.out.println("Ecco la lista completa dei progetti");
		Progetti.letturaDatiProgetto(conn);
		
		
		System.out.print("Inserisci id del progetto che vuoi selezionare: ");
		int id_progetto=scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("A quale team vuoi assegnarlo?: ");
		int id_team=scanner.nextInt();
		scanner.nextLine();
		
		String sql = "INSERT INTO team_progetti(id_team, id_progetto) VALUES (?,?)";
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
		{

			pstmt.setInt(1, id_team);
			pstmt.setInt(2, id_progetto);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0)
			{
				System.out.println("Team  con ID " + id_team + " assegnato correttamente al progetto: " + id_progetto);
			} else
			{
				System.out.println("Nessun team assegnato. Verificare l'ID.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo che assegna un diverso progetto ad un team
	 *
	 * @param conn   Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */
	
public static void modificaTeamProgetto(Connection conn, Scanner scanner) {
		
		System.out.println("Ecco la lista completa dei team.");
		letturaDatiTeam(conn);
		System.out.println("Ecco la lista completa dei progetti");
		Progetti.letturaDatiProgetto(conn);
		System.out.print("Seleziona un progetto: ");
		int id_progetto=scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("A quale team vuoi assegnarlo?: ");
		int id_team=scanner.nextInt();
		scanner.nextLine();
		
		String sql = "UPDATE team_progetti SET id_team=? WHERE id_progetto=?";
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
		{

			pstmt.setInt(1, id_team);
			pstmt.setInt(2, id_progetto);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0)
			{
				System.out.println("Team  con ID " + id_team + " assegnato correttamente al progetto: " + id_progetto);
			} else
			{
				System.out.println("Nessun team assegnato. Verificare l'ID.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}


}
