package main;

import java.sql.*;
import java.util.Scanner;

public class Team {
	int id_team;
	String nome;
	int id_progetto;
	int id_manager;
	
	public Team(int id_team,String nome,int id_progetto, int id_manager) {
		this.id_team=id_team;
		this.nome=nome;
		this.id_progetto=id_progetto;
		this.id_manager=id_manager;
	}
	
	/**
	 * Metodo che assegna un progetto ad un team
	 *
	 * @param credenziali   Apertura della connessione al DB
	 * @param scanner passiamo lo scanner come parametro
	 */
	
	public static void letturaDatiTeam(Credenziali credenziali)
	{
		String QUERY = "SELECT * FROM Team";

		try (Connection conn = credenziali.connessione();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);)
		{
			while (rs.next())
			{
				int id_team = rs.getInt("id_team");
				String nome = rs.getString("nome");
				

				System.out.printf("id: %d | nome: %s | cognome: %s | stipendio: %.2f\n", id_team, nome);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public static void assegnaTeamProgetto(Scanner scanner, Credenziali credenziali) {
		
		System.out.println("Ecco la lista completa dei team.");
		letturaDatiTeam(credenziali);
		System.out.println("Ecco la lista completa dei progetti");
		Progetti.letturaDatiProgetto(credenziali);
		
		
		System.out.print("Inserisci id del progetto che vuoi selezionare: ");
		int id_progetto=scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("A quale team vuoi assegnarlo?: ");
		int id_team=scanner.nextInt();
		scanner.nextLine();
		
		String sql = "INSERT INTO team_progetti(id_team,id_progetti) VALUES (?,?)";
		try (Connection conn = credenziali.connessione();
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
	
public static void modificaTeamProgetto(Scanner scanner, Credenziali credenziali) {
		
		System.out.print("Seleziona un progetto: ");
		int id_progetto=scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("A quale team vuoi assegnarlo?: ");
		int id_team=scanner.nextInt();
		scanner.nextLine();
		
		String sql = "UPDATE team_progetti SET id_team=? WHERE id_progetto=?";
		try (Connection conn = credenziali.connessione();
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
